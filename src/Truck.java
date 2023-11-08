import templatePattern.RouteTemplate;

public class Truck {
    Driver driver;
    RouteTemplate route;
    private double weightOfCargo;

    private double weightOfTruck;
    private String brand;

    private Truck(TruckBuilder truckBuilder) { //ca sa fie facut in builder
        this.weightOfTruck = truckBuilder.weightOfTruck;
        this.brand = truckBuilder.brand;
        this.weightOfCargo = truckBuilder.weightOfCargo;
        this.driver = truckBuilder.driver;
        this.route = truckBuilder.route;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getBrand() {
        return this.brand;
    }

    public static class TruckBuilder {

        //default attributes
        private double weightOfTruck;
        private String brand;

        //add ons
        private double weightOfCargo;
        Driver driver;
        RouteTemplate route;

        public String getBrand() {
            return brand;
        }

        public Driver getDriver() {
            return driver;
        }

        public TruckBuilder(double weightOfTruck, String brand) {
            this.weightOfTruck = weightOfTruck;
            this.brand = brand;
        }

        public TruckBuilder addWeightOfCargo(double weightOfCargo){
            this.weightOfCargo = weightOfCargo;
            return this;
        }

        public TruckBuilder addDriver(Driver driver){
            this.driver = driver;
            return this;
        }
        public TruckBuilder addRoute(RouteTemplate route){
            this.route = route;
            return this;
        }

        public Truck build(){
            return new Truck(this);

        }
    }
}
