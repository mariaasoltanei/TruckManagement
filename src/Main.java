import decoratorPattern.FoodStop;
import decoratorPattern.SleepStop;
import decoratorPattern.StandardStop;
import strategyPattern.CreditCardStrategy;
import strategyPattern.PayPalStrategy;
import templatePattern.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO: CREATE SOME ROUTES
        //TODO: DISPOSE EVERY FRAME
        List<Driver> drivers = new ArrayList<Driver>();
        final java.awt.List driversNames = new java.awt.List(drivers.size(), false);
        List<RouteTemplate> routes = new ArrayList<RouteTemplate>();
        final java.awt.List routesNames = new java.awt.List(routes.size(), false);
        List<Road> roads = new ArrayList<Road>();
        final java.awt.List roadsNames = new java.awt.List(roads.size(), false);
        List<Stop> stops = new ArrayList<Stop>();
        final java.awt.List stopsType = new java.awt.List(stops.size(), false);


        Road r1 = new Road("E85", 100);
        roads.add(r1);
        roadsNames.add(r1.getName());
        Road r2 = new Road("DN1", 400);
        roads.add(r2);
        roadsNames.add(r2.getName());
        Road r3 = new Road("A3", 234);
        roads.add(r3);
        roadsNames.add(r3.getName());
        Road r4 = new Road("R56", 564);
        roads.add(r4);
        roadsNames.add(r4.getName());
        Road r5 = new Road("T23", 321);
        roads.add(r5);
        roadsNames.add(r5.getName());
        Road r6 = new Road("N56", 765);
        roads.add(r6);
        roadsNames.add(r6.getName());

        Stop sleepStop1 = new SleepStop(new StandardStop(), "Inn");
        stops.add(sleepStop1);
        stopsType.add("Sleep");
        Stop foodStop1 = (Stop) new FoodStop(new StandardStop(), "Dedulesti");
        stops.add(foodStop1);
        stopsType.add("Food");

        Frame mainFrame = new Frame();
        Button addTruck = new Button("Add Truck");
        addTruck.setBounds(50, 100, 80, 30);
        Button addDriver = new Button("Add Driver");
        addDriver.setBounds(150, 100, 80, 30);
        Button createRoute = new Button("Create Route");
        createRoute.setBounds(250, 100, 80, 30);
        mainFrame.add(addTruck);
        mainFrame.add(addDriver);
        mainFrame.add(createRoute);

        mainFrame.setSize(400, 300);
        mainFrame.setTitle("Truck framework");
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        addTruck.addActionListener(e -> {
            Frame truckFrame = new Frame();
            Button goMainFrame = new Button("<< Back");
            Button createTruck = new Button("Create Truck");
            Label weightOfTruck = new Label("Weight of truck:");
            TextField weightOfTruckTF = new TextField();
            Label truckBrand = new Label("Brand:");
            TextField truckBrandTF = new TextField();
            Label driverName = new Label("Choose driver:");
            Label weightOfCargo = new Label("Weight of cargo:");
            TextField weightOfCargoTF = new TextField();
            Label chooseRoute = new Label("Choose a route");
            Checkbox driverCB = new Checkbox();
            boolean isDriver = false;
            Checkbox weightOfCargoCB = new Checkbox();
            boolean isWeightOfCargo = false;
            Checkbox routeCB = new Checkbox();
            boolean isRoute = false;

            goMainFrame.setBounds(50, 500, 80, 30);
            createTruck.setBounds(220, 500, 80, 30);
            weightOfTruck.setBounds(20, 80, 100, 30);
            weightOfTruckTF.setBounds(150, 80, 100, 30);
            truckBrand.setBounds(20, 120, 100, 30);
            truckBrandTF.setBounds(150, 120, 100, 30);
            driverName.setBounds(20, 150, 100, 30);
            driverCB.setBounds(130, 150, 50, 30);
            weightOfCargo.setBounds(20, 200, 100, 30);
            weightOfCargoCB.setBounds(130, 200, 50, 30);
            chooseRoute.setBounds(20, 250, 100, 30);
            routeCB.setBounds(130, 250, 50, 30);

            driverCB.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        driversNames.setBounds(200, 150, 70, 50);
                        truckFrame.add(driversNames);
                    } else {
                        truckFrame.remove(driversNames);
                    }
                }
            });
            weightOfCargoCB.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        weightOfCargoTF.setBounds(200, 190, 70, 30);
                        truckFrame.add(weightOfCargoTF);
                    } else {
                        truckFrame.remove(weightOfCargoTF);
                    }
                }
            });
            routeCB.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        routesNames.setBounds(200, 250, 70, 40);
                        truckFrame.add(routesNames);
                    } else {
                        truckFrame.remove(routesNames);
                    }
                }
            });

            truckFrame.add(goMainFrame);
            truckFrame.add(createTruck);
            truckFrame.add(driverName);
            truckFrame.add(weightOfTruck);
            truckFrame.add(weightOfTruckTF);
            truckFrame.add(truckBrand);
            truckFrame.add(truckBrandTF);
            truckFrame.add(driverCB);
            truckFrame.add(weightOfCargoCB);
            truckFrame.add(routeCB);
            truckFrame.add(weightOfCargo);
            truckFrame.add(chooseRoute);

            truckFrame.setSize(600, 600);
            truckFrame.setTitle("Create Truck");
            truckFrame.setLayout(null);
            truckFrame.setVisible(true);
            goMainFrame.addActionListener(e1 -> truckFrame.dispose());
            createTruck.addActionListener(e3 -> {
                //TODO: ADD MORE USE CASES!!!
                Truck truck1;
                System.out.println(driverCB.getState());
                if (driverCB.getState() == true) {
                    if (routeCB.getState() == true) {
                        if (weightOfCargoCB.getState() == true) {
                            //System.out.println(drivers.get(driversNames.getSelectedIndex()));
                            truck1 = new Truck.TruckBuilder(Double.parseDouble(weightOfTruckTF.getText()), truckBrandTF.getText()).addDriver(drivers.get(driversNames.getSelectedIndex())).addWeightOfCargo(Double.parseDouble(weightOfCargoTF.getText())).addRoute(routes.get(routesNames.getSelectedIndex())).build();
                            System.out.println(truck1.getBrand() + " " + truck1.getDriver().getFullName());
                        }
                    }
                }

            });
        });


        addDriver.addActionListener(e -> {
            Frame driverFrame = new Frame();
            Button goMainFrame = new Button("<< Back");
            Button createDriver = new Button("Create Driver");
            Label fullName = new Label("Full Name:");
            TextField fullNameTF = new TextField();
            Label salary = new Label("Salary:");
            TextField salaryTF = new TextField();

            goMainFrame.setBounds(50, 200, 80, 30);
            createDriver.setBounds(220, 200, 80, 30);

            fullName.setBounds(20, 80, 100, 30);
            fullNameTF.setBounds(150, 80, 100, 30);
            salary.setBounds(20, 120, 100, 30);
            salaryTF.setBounds(150, 120, 100, 30);

            driverFrame.add(goMainFrame);
            driverFrame.add(createDriver);
            driverFrame.add(fullName);
            driverFrame.add(fullNameTF);
            driverFrame.add(salary);
            driverFrame.add(salaryTF);

            driverFrame.setSize(400, 300);
            driverFrame.setTitle("Create driver");
            driverFrame.setLayout(null);
            driverFrame.setVisible(true);
            goMainFrame.addActionListener(e1 -> driverFrame.dispose());
            createDriver.addActionListener(e2 -> {
                drivers.add(new Driver(fullNameTF.getText(), Double.parseDouble(salaryTF.getText())));
                driversNames.add(fullNameTF.getText());
                System.out.println("Driver " + fullNameTF.getText() + "was created.");
            });
        });

        //cargo weight and truck weight come from truck
        createRoute.addActionListener(e -> {
            //route1.buildRoute("Bucuresti", "Suceava",122,233, report);
            Frame routeFrame = new Frame();
            Button goMainFrame = new Button("<< Back");
            Button addRoute = new Button("Create Route");
            Label startLocation = new Label("Start Location");
            TextField startLocationTF = new TextField();
            Label finalLocation = new Label("Final location:");
            TextField finalLocationTF = new TextField();
            Label cargoWeight = new Label("Cargo weight:");
            TextField cargoWeightTF = new TextField();
            Label truckWeight = new Label("Truck weight:");
            TextField truckWeightTF = new TextField();
            Label chooseRoads = new Label("Select roads:");
            Label chooseStop = new Label("Select stops:");
            Label payBill = new Label("Pay bill?");
            Checkbox payBillCB = new Checkbox();
            Checkbox cardPayCB = new Checkbox("Card");
            Checkbox payPalCB = new Checkbox("PayPal");
            roadsNames.setMultipleMode(true);
            stopsType.setMultipleMode(true);

            goMainFrame.setBounds(50, 500, 80, 30);
            addRoute.setBounds(220, 500, 80, 30);
            startLocation.setBounds(20, 80, 100, 30);
            startLocationTF.setBounds(150, 80, 100, 30);
            finalLocation.setBounds(20, 120, 100, 30);
            finalLocationTF.setBounds(150, 120, 100, 30);
            cargoWeight.setBounds(20, 150, 100, 30);
            cargoWeightTF.setBounds(150, 150, 100, 30);
            truckWeight.setBounds(20, 180, 100, 30);
            truckWeightTF.setBounds(150, 180, 100, 30);
            chooseRoads.setBounds(20, 210, 100, 30);
            roadsNames.setBounds(150, 210, 100, 70);
            chooseStop.setBounds(20, 280, 100, 30);
            stopsType.setBounds(150, 280, 100, 30);
            payBill.setBounds(20, 310, 100, 30);
            payBillCB.setBounds(150, 310, 50, 30);
            cardPayCB.setBounds(200, 310, 50, 30);
            payPalCB.setBounds(260, 310, 50, 30);

            routeFrame.add(goMainFrame);
            routeFrame.add(addRoute);
            routeFrame.add(startLocation);
            routeFrame.add(startLocationTF);
            routeFrame.add(finalLocation);
            routeFrame.add(finalLocationTF);
            routeFrame.add(cargoWeight);
            routeFrame.add(cargoWeightTF);
            routeFrame.add(truckWeight);
            routeFrame.add(truckWeightTF);
            routeFrame.add(chooseRoads);
            routeFrame.add(roadsNames);
            routeFrame.add(chooseStop);
            routeFrame.add(stopsType);
            routeFrame.add(payBill);
            routeFrame.add(payBillCB);
            routeFrame.add(cardPayCB);
            routeFrame.add(payPalCB);

            routeFrame.setSize(600, 600);
            routeFrame.setTitle("Create route");
            routeFrame.setLayout(null);
            routeFrame.setVisible(true);
            goMainFrame.addActionListener(e1 -> routeFrame.dispose());
            addRoute.addActionListener(e4 -> {
                RouteTemplate r;
                Bill b = new Bill(LocalDate.now(), 250);
                Report report1 = new Report("Report1", LocalDate.now());
                List<Road> chosenRoads = new ArrayList<>();
                List<Integer> indexRoads = new ArrayList<>();
                for (Integer index : roadsNames.getSelectedIndexes()) {
                    indexRoads.add(index);
                }
                for (int i = 0; i < indexRoads.size(); i++) {
                    chosenRoads.add(roads.get(indexRoads.get(i)));
                    System.out.println(roads.get(indexRoads.get(i)).getName());
                }
                List<Stop> chosenStops = new ArrayList<>();
                List<Integer> indexStops = new ArrayList<>();
                for (Integer index : stopsType.getSelectedIndexes()) {
                    indexStops.add(index);
                }
                for (int i = 0; i < indexStops.size(); i++) {
                    chosenStops.add(stops.get(indexStops.get(i)));
                    System.out.println(stops.get(indexStops.get(i)).getClass());
                }
                boolean isSleepStop = false;
                for(int i = 0; i < chosenStops.size(); i++) {
                    if(chosenStops.get(i).getClass().getName() == "decoratorPattern.SleepStop"){
                        isSleepStop = true;
                    }
                }
                if (payBillCB.getState() == true) {
                    if (cardPayCB.getState() == true) {
                        b.pay(new CreditCardStrategy("Maria", "1234567890123456", "786", "12/15"));
                    } else if (payPalCB.getState() == true) {
                        b.pay(new PayPalStrategy("maria.asoltanei@gmail.com", "1234"));
                    } else {
                        System.out.println("Payment unsuccessful");
                    }
                } else {
                    System.out.println("Do not forget to pay the bill. It costs " + b.getAmount());
                }
                int distance = 0;
                for (int i = 0; i < chosenRoads.size(); i++) {
                    distance += chosenRoads.get(i).getKms();
                }
                if (distance > 500 && isSleepStop) {
                    r = new RouteType1();
                } else {
                    r = new RouteType2();
                }
                System.out.println(r.getClass().getName());
                r.buildRoute(startLocationTF.getText(), finalLocationTF.getText(), Double.parseDouble(cargoWeightTF.getText()), Double.parseDouble(truckWeightTF.getText()), chosenRoads, b, report1, chosenStops);
                routes.add(r);
                routesNames.add(startLocationTF.getText() + "-" + finalLocationTF.getText());
                System.out.println("Route " + r.getStartLocation() + "-" + r.getFinalLocation() + " was created and it is " + distance + " kilometers long.");
            });
        });
    }
}
