package ACO15.GIT.src.ua.artcode.classWork.week1.Parking;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Ticket {

    private long number;
    private int placeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;// null
    private long duration;
    private boolean open;//

    public void open(int placeId){
    number = System.currentTimeMillis();
    this.placeId = placeId;
    startDate = LocalDateTime.now();
    open = true;
    }

    public void close(){
    endDate = LocalDateTime.now();

    Date eDate = Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant());
    Date sDate = Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant());

    // millis
    long diff = eDate.getTime() - sDate.getTime();

    duration = (diff / 1000) / 60 / 60;
     }

     public long getNumber() {
     return number;
     }

     public int getPlaceId() {
     return placeId;
     }

     public LocalDateTime getStartDate() {
     return startDate;
     }

     public LocalDateTime getEndDate() {
     return endDate;
     }

      public long getDuration() {
      return duration;
      }

       public boolean isOpen() {
       return open;
       }
}
