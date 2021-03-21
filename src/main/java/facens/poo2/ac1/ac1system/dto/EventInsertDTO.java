package facens.poo2.ac1.ac1system.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventInsertDTO {
    private String emailcontact;
    private String description;
    private String place;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalTime starttime;
    private LocalTime endtime;
    
    
    public String getEmailcontact() {
        return emailcontact;
    }
    public void setEmailcontact(String emailcontact) {
        this.emailcontact = emailcontact;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    public LocalDate getEnddate() {
        return enddate;
    }
    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }
    public LocalTime getStarttime() {
        return starttime;
    }
    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }
    public LocalTime getEndtime() {
        return endtime;
    }
    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }


    
}
