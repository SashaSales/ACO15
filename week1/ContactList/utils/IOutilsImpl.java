package ua.artcod.homeWork.week1.ContactList.utils;

import ua.artcod.homeWork.week1.ContactList.model.Contact;

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


    public void writeInto(String path, String content) throws FileNotFoundException {

        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File: " + path + " not founded");
        }

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(file))) {
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendTo(String path, String content) throws FileNotFoundException {

        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File: " + path + " not founded");
        }

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(file, true))) {
            writer.append(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // touch == create new file

    public static boolean createFile(String path) {

        File file = new File(path);

        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("False touch: " + path + ", file already exists");
            return false;
        }
        return false;
    }


    public boolean deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        } else {
            System.out.println("False delete: " + path + ", not found");
            return false;
        }
    }


    public boolean copyFile(String src, String dest) {
        File source = new File(src);
        File destination = new File(dest);

        try {
            Files.copy(source.toPath(), destination.toPath());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<String> grep(String src, String keyWord) {

        File file = new File(src);
        List<String> result = new ArrayList<>();
        String temp = "";

        if (file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((temp = reader.readLine()) != null) {
                    if (temp.contains(keyWord)) {
                        result.add(temp);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (file.isDirectory()) {
                for (File item : file.listFiles()) {

                    if (item.isFile()) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(item))) {
                            while ((temp = reader.readLine()) != null) {
                                if (temp.contains(keyWord)) {
                                    result.add(temp);
                                }
                            }

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return result;
    }


    public Object clone(Object obj) {

        try (ByteArrayOutputStream outByteArr = new ByteArrayOutputStream();
             ObjectOutputStream out =
                     new ObjectOutputStream(
                             new BufferedOutputStream(outByteArr))) {

            out.writeObject(obj);

            try (ByteArrayInputStream inputByteArr = new ByteArrayInputStream(outByteArr.toByteArray());
                 ObjectInputStream input =
                         new ObjectInputStream(
                                 new BufferedInputStream(inputByteArr))) {

                return input.readObject();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public byte[] toByteArr(Object obj) {

        try (ByteArrayOutputStream outByteArr = new ByteArrayOutputStream();
             ObjectOutputStream out =
                     new ObjectOutputStream(
                             new BufferedOutputStream(outByteArr))) {

            out.writeObject(obj);

            return outByteArr.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


    public Object fromByteArr(byte[] arr) {

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new ByteArrayInputStream(arr)))) {
            return input.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void saveObjToFile(Object obj, String filePath) {

        if (obj != null) {
            File file = new File(filePath);
            if (!file.exists()) {
                createFile(filePath);
            } else {
                try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream outputStream = new ObjectOutputStream(fos)) {

                    outputStream.writeObject(obj);
                    outputStream.flush();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static  void savePathToFile(String pathFile, String pathForDB){

        File file = new File(pathFile);
        if (file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(pathFile));
            printWriter.append(pathForDB);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String loadPathFromFile(String pathFile){
        String pathDB = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            pathDB = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathDB;
    }


    public static Object loadObjFromFile(String filePath) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream input =
                     new ObjectInputStream(
                             new BufferedInputStream(fis))) {

            return input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }

    }


    public void downloadFile(String url, String localPathName) {

        try (InputStream inputStream = new URL(url).openStream()) {
            Files.copy(inputStream, new File(localPathName).toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public List<String> find(File dir, String keyWord) {


        // 1. get list of ALL file and folders
        List<File> fullTree = getFullTreeOfFiles(dir);

        // 2. by FileNameFilter from "fullTree" get names of files and folder that contain keyword IN TITLE
        List<File> listFoundedByName = findFilesByName(fullTree, keyWord);

        // 3. by FileReader from "fullTree" get names of file and folder that contain keyword IN CONTENT
        List<File> listFoundedByContent = findFilesWithContent(fullTree, keyWord);

        // 4. concat ArrayLists, delete dublicats

        List<File> listOfFoundedFiles = new ArrayList<>();
        listOfFoundedFiles.addAll(listFoundedByName);
        listOfFoundedFiles.addAll(listFoundedByContent);

        List<String> result = new ArrayList<>();
        for (File file : listOfFoundedFiles) {
            if (!result.contains(file.toString()))
                result.add(file.toString());
        }

        return result;
    }

    public static List<File> findFilesByName(List<File> fullTree, String keyWord) {
        List<File> listFoundedByName = new ArrayList<>();
        for (File file : fullTree) {
            if (file.getName().contains(keyWord)) {
                listFoundedByName.add(file);
            }
        }
        return listFoundedByName;
    }

    public static List<File> findFilesWithContent(List<File> fullTree, String keyWord) {
        List<File> listFoundedByContent = new ArrayList<>();

        for (File file : fullTree) {
            if (file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    String temp = "";
                    while ((temp = reader.readLine()) != null) {
                        if (temp.contains(keyWord)) {
                            listFoundedByContent.add(file);
                            break;
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listFoundedByContent;
    }

    public static List<File> getFullTreeOfFiles(File root) {

        List<File> result = new ArrayList<>();

        for (File file : root.listFiles()) {
            if (file.isFile()) {
                result.add(file);
            }
            if (file.isDirectory()) {
                result.add(file);
                List<File> recursionResult = getFullTreeOfFiles(file);
                result.addAll(recursionResult);
            }
        }
        return result;
    }
}
