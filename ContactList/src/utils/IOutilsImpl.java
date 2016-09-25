package utils;

import constants.Contstants;
import model.Contact;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 11.09.2016.
 */
public class IOutilsImpl implements Serializable{


    public static boolean saveObjToFile(Object obj) throws IOException {

        boolean res = false;

        String pathDB = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());

        if (obj != null) {
            File fileDB = new File(pathDB);
            if (!fileDB.exists()) {
                fileDB.createNewFile();
            } else {
                try (FileOutputStream fos = new FileOutputStream(fileDB);
                     ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {

                    outputStream.writeObject(obj);
                    outputStream.flush();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                res = true;
            }
        }
        return res;
    }


    public static  void savePathToFile(String pathFile, String pathForDB){

        File file = new File(pathFile);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(pathFile));
            printWriter.write(pathForDB);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String loadPathFromFile(String filePath){
        String pathDB = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            pathDB = br.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return pathDB;
    }


    public static Object loadObjFromFile() throws IOException {

        String filePath = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream input =
                     new ObjectInputStream(new BufferedInputStream(
                             fis))) {

            return input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }

    }


    public static void saveLogToFile(String logs) throws IOException {

        File file = new File (Contstants.getPathForLoger());
        if (!file.exists()){
            file.createNewFile();
        }

        try {
            PrintWriter printWrite = new PrintWriter(new FileWriter(Contstants.getPathForLoger(), true), true);
            printWrite.println(logs);
            printWrite.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
