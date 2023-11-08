package decoratorPattern;

import templatePattern.RouteTemplate;
import templatePattern.Stop;

import java.time.LocalDate;

public class FoodStop extends StopDecorator {
    String restaurantName;
    public FoodStop(Stop stop, String restaurantName) {
        super(stop);
        this.restaurantName = restaurantName;
    }

    @Override
    public void chooseStop(LocalDate stopDate, String location, double allowedTime, RouteTemplate route) {
        super.chooseStop(stopDate, location, allowedTime, route);
        if(allowedTime > 1 || allowedTime < 3){
            System.out.println("Please choose another type of stop");
        }
    }
    public String getStopType() {
        return "Food stop";
    }

}
