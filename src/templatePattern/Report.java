package templatePattern;

import java.time.LocalDate;

public class Report {
    private String description;
    private LocalDate dateOfReport;

    public Report(String description, LocalDate dateOfReport) {
        this.description = description;
        this.dateOfReport = dateOfReport;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfReport(LocalDate dateOfReport) {
        this.dateOfReport = dateOfReport;
    }
}
