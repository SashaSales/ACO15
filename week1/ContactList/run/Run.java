package ua.artcod.homeWork.week1.ContactList.run;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.view.IView;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by work on 10.09.2016.
 */
public class Run {

    //private static String pathForDatabase;
    //private IappDB iappDB;
    //= "temp/mydb.txt";

    public static void main(String[] args) throws IOException {

        //IappDB iappDB = new appDBimpl(pathForDatabase);
        String pathForDatabase = "temp/myDB.txt";
        IappDB iappDB;

        if (!(new File(pathForDatabase)).exists()){
            IView iViewPath = new IView(new Scanner(System.in));
            pathForDatabase = iViewPath.pathForDatabase();
            iappDB = new appDBimpl(pathForDatabase);

        } else {
            iappDB = new appDBimpl(pathForDatabase);
            iappDB.loadDB(pathForDatabase);
        }


        IControllerlist iControllerlist = new ControllerListImpl(iappDB, pathForDatabase);
        IView iView = new IView(new Scanner(System.in), iControllerlist);

        iView.start();


    }

}
