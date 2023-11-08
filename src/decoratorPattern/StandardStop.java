package decoratorPattern;

import templatePattern.RouteTemplate;
import templatePattern.Stop;

import java.time.LocalDate;

public class StandardStop implements Stop {
    private LocalDate stopDate;
    private String location;
    private RouteTemplate route;
    private double allowedTime;


    @Override
    public void chooseStop(LocalDate stopDate, String location, double allowedTime, RouteTemplate route) {
        this.stopDate = stopDate;
        this.location = location;
        this.allowedTime = allowedTime;
        this.route = route;
    }
}
