package constants;

/**
 * Created by work on 13.09.2016.
 */
public class Contstants {

    final static String PATH_FOR_SAVEDB = "temp/pathForDB.txt";
    final static String DEFOULT_PATH_FOR_SAVEDB = "temp/myDB.txt";
    final static String PATH_FOR_DB = "temp/myDB.txt";
    final static String PATH_FOR_LOGER = "temp/logger.txt";

    public static String getPathForSavedb() {
        return PATH_FOR_SAVEDB;
    }

    public static String getDefoultPathForSavedb() {
        return DEFOULT_PATH_FOR_SAVEDB;
    }

    public static String getPathForDb() {
        return PATH_FOR_DB;
    }

    public static String getPathForLoger() {
        return PATH_FOR_LOGER;
    }
}
