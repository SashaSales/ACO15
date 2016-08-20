package ACO15.GIT.src.ua.artcode.classWork.week2.crm.model;

/**
 * Created by work on 14.08.2016.
 */
public class Project {

    private String id;
    private String title;
    private String description;

    private Task[] tasks;
    private Manager[] managers;
    private Dev[] devs;

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public void setManagers(Manager[] managers) {
        this.managers = managers;
    }

    public void setDevs(Dev[] devs) {
        this.devs = devs;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Manager[] getManagers() {
        return managers;
    }

    public Dev[] getDevs() {
        return devs;
    }

    public String asString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
