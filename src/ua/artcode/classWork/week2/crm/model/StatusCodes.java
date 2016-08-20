package ACO15.GIT.src.ua.artcode.classWork.week2.crm.model;

/**
 * Created by work on 14.08.2016.
 */
public class StatusCodes {

    public static final int NEW = 0;
    public static final int IN_PROGRESS = 1;
    public static final int TEST = 2;
        public static final int DONE = 3;

    public static String getStatusName(int statusCode) {
        switch (statusCode){
            case 0 :
                return "NEW";
            case 1 :
                return "IN_PROGRESS";
            case 2 :
                return "TEST";
            case 3 :
                return "DONE";
            default:
                return "UnknownCode";
        }
    }
}
