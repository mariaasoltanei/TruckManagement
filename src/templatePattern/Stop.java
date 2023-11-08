package templatePattern;

import templatePattern.RouteTemplate;

import java.time.LocalDate;

public interface Stop {
    public void chooseStop(LocalDate stopDate, String location, double allowedTime, RouteTemplate route);

}
