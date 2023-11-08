package templatePattern;

import java.util.List;

public abstract class RouteTemplate {
    private String startLocation;
    private String finalLocation;

    private double cargoWeight;
    private double truckWeight;

    public final void buildRoute(String startLocation, String finalLocation, double cargoWeight, double truckWeight, List<Road> roads, Bill bill, Report report, List<Stop> stops){
        setLocation(startLocation, finalLocation);
        addRoads(roads);
        setNoKMs(); //ia km din roads
        addStops(stops);
        addWeightOfCargo(cargoWeight);
        addTruckWeight(truckWeight);
        addReport(report);
        addBill(bill);

    }
    //def
    private void setLocation(String startLocation, String finalLocation){
        this.startLocation = startLocation;
        this.finalLocation = finalLocation;
    }

    private void addWeightOfCargo(double cargoWeight){
        this.cargoWeight = cargoWeight;
    }
    private void addTruckWeight(double truckWeight){
        this.truckWeight = truckWeight;
    }

    public abstract double setNoKMs();
    public abstract void addRoads(List<Road> roads);
    //if it is a short route then it does not need sleep stop
    public abstract void addStops(List<Stop> stops); //might be list of stop
    public abstract void addReport(Report report);
    public abstract void addBill(Bill bill);

    public String getStartLocation() {
        return startLocation;
    }

    public String getFinalLocation() {
        return finalLocation;
    }
}
