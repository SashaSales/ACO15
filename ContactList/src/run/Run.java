package run;

import exceptions.AddContactException;
import exceptions.RemoveContactException;
import exceptions.WordIsEmpty;
import appDB.IappDB;
import appDB.appDBimpl;
import constants.Contstants;
import controller.ControllerListImpl;
import controller.IControllerlist;
import utils.IOutilsImpl;
import view.console.IView;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by work on 10.09.2016.
 */
public class Run {

    //private static String pathForDatabase;
    //private IappDB iappDB;
    //= "temp/mydb.txt";

    public static void main(String[] args) throws IOException, RemoveContactException, AddContactException, WordIsEmpty {

        IappDB iappDB = null;
        IControllerlist iControllerlist = null;
        Scanner sc = new Scanner(System.in);

        String pathDB = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());

        if (pathDB == null){
            IView iView = new IView(sc);
            iView.pathForDatabase();
            iappDB = new appDBimpl();
        } else {
            iappDB = new appDBimpl();

            iappDB.loadDB();

        }

        iControllerlist = new ControllerListImpl(iappDB);
        IView iView = new IView(new Scanner(System.in), iControllerlist);

        iView.start();


    }

}
