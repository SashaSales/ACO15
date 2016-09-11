
package ua.artcod.homeWork.week1.ContactList.test;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.model.Contact;

public class Test {





    public static void main(String[] args) {
        IappDB iappDB = new appDBimpl();
        IControllerlist iControllerlist = new ControllerListImpl(iappDB);

        iControllerlist.addContact("Sergey", "0677777777", "Sergey@gmail.com");
        iControllerlist.addContact("Alex", "0737373737", "Alex@gmail.com");
        iControllerlist.addContact("Ivan", "0733333333", "Ivan@gmail.com");
        iControllerlist.addContact("Elena", "0505050505", "Elena@gmail.com");
        iControllerlist.addContact("Anya", "0989898989", "Anya@gmail.com");
        iControllerlist.addContact("Yulya", "0636363636", "Yulya@gmail.com");
        iControllerlist.addContact("Senya", "0939393939", "Senya@gmail.com");

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

