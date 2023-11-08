package decoratorPattern;

import templatePattern.RouteTemplate;
import templatePattern.Stop;

import java.time.LocalDate;

public abstract class StopDecorator implements Stop {
    private Stop stop;
    public StopDecorator(Stop stop){
        this.stop = stop;
    }
    @Override
    public void chooseStop(LocalDate stopDate, String location, double allowedTime, RouteTemplate route){
        this.stop.chooseStop(stopDate, location, allowedTime, route);
    }

}
