package ua.artcod.homeWork.week1.ContactList.run;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.constants.Contstants;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.utils.IOutilsImpl;
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

        IappDB iappDB = null;
        Scanner sc = new Scanner(System.in);

        String pathDB = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());

        if (pathDB == null){
            IView iView = new IView(sc);
            iView.pathForDatabase();
            iappDB = new appDBimpl();
        } else {
            iappDB = iappDB.loadDB();
        }


        IControllerlist iControllerlist = new ControllerListImpl(iappDB);
        IView iView = new IView(new Scanner(System.in), iControllerlist);

        iView.start();


    }

}
