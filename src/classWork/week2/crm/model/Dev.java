package ACO15.GIT.src.ua.artcode.classWork.week2.crm.model;

/**
 * Created by work on 14.08.2016.
 */
public class Dev {

    private long id;
    private String fullname;
    private String email;

    private Project[] projects;
    private Task[] myTasks;

    public Dev(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public Task[] getMyTasks() {
        return myTasks;
    }

    public void setMyTasks(Task[] myTasks) {
        this.myTasks = myTasks;
    }

}
