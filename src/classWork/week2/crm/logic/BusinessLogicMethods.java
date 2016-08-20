package ACO15.GIT.src.ua.artcode.classWork.week2.crm.logic;

import ACO15.ua.artcod.classWork.week2.crm.db.AppDB;
import ACO15.ua.artcod.classWork.week2.crm.model.Project;
import ACO15.ua.artcod.classWork.week2.crm.model.Task;
import java.time.LocalDateTime;

public class BusinessLogicMethods {

    private AppDB appDB;

    public BusinessLogicMethods(AppDB appDB) {
        this.appDB = appDB;
    }

    public Project createProject(long creatorId, String title, String desc) {

        Project project = new Project(title, desc);
        Project created = appDB.addProject(project);

        return created;
    }

    public Task createTask(long creatorId, String title,
                           String desc, long executorId, int workHours){

        return null;
    }

    public  boolean assignTask(String taskId, long devId){
        return false;
    }

    public  Task[] getExecutorTasks(long executorId){
        return null;
    }

    public  Task[] getProjectTasks(long projectId){
        return null;
    }

    // 23, 34, ABC-23
    // -1, -1,
    public  Task[] filter(long ownerId, long executorId,
                          String projectId, int statusCode,
                          String startDate, String endDate){
        return null;
    }

    public  Task getTaskById(String taskId){
        return null;
    }

    public  boolean changeStatus(String taskId, int statusCode){
        return false;
    }


}


