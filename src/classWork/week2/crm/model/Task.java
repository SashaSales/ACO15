package ACO15.GIT.src.ua.artcode.classWork.week2.crm.model;
import java.time.LocalDateTime;
/**
 * Created by work on 14.08.2016.
 */
public class Task {

    private String id;
    private String title;
    private String description;
    private Manager owner;
    private int status;

    private LocalDateTime creationTime;
    // hours
    private int workHours;
    private LocalDateTime closedTime;

    private Dev executor;
    private Comment[] comments;

}
