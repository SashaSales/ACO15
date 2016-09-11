package ua.artcod.homeWork.week1.ContactList.run;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.view.IView;

import java.util.Scanner;

/**
 * Created by work on 10.09.2016.
 */
public class Run {

    public static void main(String[] args) {

        IappDB iappDB = new appDBimpl();
        IControllerlist iControllerlist = new ControllerListImpl(iappDB);

        IView iView = new IView(new Scanner(System.in), iControllerlist);
        iView.start();

    }

}
