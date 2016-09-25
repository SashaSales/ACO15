
package test;

import exceptions.AddContactException;
import exceptions.ContactNullPointerException;
import exceptions.RemoveContactException;
import appDB.IappDB;
import appDB.appDBimpl;
import constants.Contstants;
import controller.ControllerListImpl;
import controller.LogerControllerProxy;
import controller.IControllerlist;
import utils.IOutilsImpl;
import view.console.IView;

import java.io.IOException;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException, AddContactException, ContactNullPointerException, RemoveContactException {


/////////////////////////////////////////////////////////
       /* IappDB iappDB = null;

        Scanner sc = new Scanner(System.in);
    String pathDB = IOutilsImpl.loadPathFromFile(Contstants.getPathForSavedb());
        if (pathDB == null){
        IView iView = new IView(sc);
        iView.pathForDatabase();
        iappDB = new appDBimpl();
           } else {
        iappDB = (IappDB) IOutilsImpl.loadObjFromFile();
          }*/

       //IappDB iappDB = new appDBimpl();
        IappDB iappDB = (IappDB) IOutilsImpl.loadObjFromFile();
        IControllerlist iControllerlist = new LogerControllerProxy(new ControllerListImpl(iappDB));


      /* iControllerlist.addContact("Sergey", "0677777777", "Sergey@gmail.com");
        iControllerlist.addContact("Alex", "0737373737", "Alex@gmail.com");
        iControllerlist.addContact("Ivan", "0733333333", "Ivan@gmail.com");
        iControllerlist.addContact("Elena", "0505050505", "Elena@gmail.com");
        iControllerlist.addContact("Anya", "0989898989", "Anya@gmail.com");
        iControllerlist.addContact("Yulya", "0636363636", "Yulya@gmail.com");
        iControllerlist.addContact("Senya", "0939393939", "Senya@gmail.com");
        iControllerlist.addContact("Serofim", "0939111939", "Serofim@gmail.com");*/


       iControllerlist.saveDB();

        //************checkUniqueName


       // iControllerlist.removeContact("Sergey");
        //Contact contact = new Contact("SSSergey", "0677777777", "SSSergey@gmail.com");
        //System.out.println(iControllerlist.updateContactInfo(0, contact));
        iControllerlist.showAll();
        //iControllerlist.showLifeContacts();
        //iControllerlist.showKievstarContacts();
        //iControllerlist.showMTSContacts();




    }

}


