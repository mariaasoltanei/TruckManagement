package decoratorPattern;

import decoratorPattern.StopDecorator;
import templatePattern.RouteTemplate;
import templatePattern.Stop;

import java.time.LocalDate;

//has hotel, allowed time is 8-9 h
public class SleepStop extends StopDecorator {
    String hotelName;
    public SleepStop(Stop stop, String hotelName) {
        super(stop);
        this.hotelName = hotelName;
    }

    @Override
    public void chooseStop(LocalDate stopDate, String location, double allowedTime, RouteTemplate route) {
        super.chooseStop(stopDate, location, allowedTime, route);
        if(allowedTime > 9 || allowedTime < 8){
            System.out.println("Please choose another type of stop");
        }
    }


    public String getStopType() {
        return "Sleep stop";
    }
}
