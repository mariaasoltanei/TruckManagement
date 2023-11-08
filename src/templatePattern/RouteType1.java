package templatePattern;

import templatePattern.RouteTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteType1 extends RouteTemplate {
    List<Stop> stops = new ArrayList<>();
    List<Road> roads =new ArrayList<>();
    Report report;
    Bill bill;
    private double noKMs;


    @Override
    public double setNoKMs() {
        for(int i = 0; i < this.roads.size(); i++){
            this.noKMs += this.roads.get(i).getKms();
        }
        return this.noKMs;
    }

    @Override
    public void addRoads(List<Road> roads) {
        this.roads = roads;
    }

    @Override
    public void addStops(List<Stop> stops) {
        this.stops = stops;

    }

    @Override
    public void addReport(Report report) {
        this.report = report;

    }

    @Override
    public void addBill(Bill bill) {
        this.bill = bill;
    }
}
