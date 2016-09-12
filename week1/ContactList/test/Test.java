
package ua.artcod.homeWork.week1.ContactList.test;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.constants.Contstants;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.model.Contact;
import ua.artcod.homeWork.week1.ContactList.utils.IOutils;
import ua.artcod.homeWork.week1.ContactList.utils.IOutilsImpl;
import ua.artcod.homeWork.week1.ContactList.view.IView;

import java.io.IOException;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String pathDB = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());
        if (pathDB == null){
            IView iView = new IView(sc);
            iView.pathForDatabase();
        }

        IappDB iappDB = new appDBimpl();
        IControllerlist iControllerlist = new ControllerListImpl(iappDB, pathDB);

        iControllerlist.addContact("1Sergey", "0677777777", "Sergey@gmail.com");
        iControllerlist.addContact("Alex", "0737373737", "Alex@gmail.com");
        iControllerlist.addContact("Ivan", "0733333333", "Ivan@gmail.com");
        iControllerlist.addContact("Elena", "0505050505", "Elena@gmail.com");
        iControllerlist.addContact("Anya", "0989898989", "Anya@gmail.com");
        iControllerlist.addContact("Yulya", "0636363636", "Yulya@gmail.com");
        iControllerlist.addContact("Senya", "0939393939", "Senya@gmail.com");

        iControllerlist.saveDB();

        IappDB iappDB1 = iControllerlist.loadDB();
        iappDB1.showAll();

        //ioUtils.saveObjToFile(appDBimpl, DB_PATH);

        //************checkUniqueName

        //iControllerlist.showAll();
        //iControllerlist.showFirstFiveContacts();
        //iControllerlist.showLastFiveContacts();
        //iControllerlist.removeContact(0);
        //iControllerlist.updateContactInfo("Sergey", "Brat");
        //iControllerlist.showAll();
        //iControllerlist.showLifeContacts();
        //iControllerlist.showKievstarContacts();
        //iControllerlist.showMTSContacts();




    }

}

