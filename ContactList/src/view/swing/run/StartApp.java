package view.swing.run;

import exceptions.AddContactException;
import appDB.IappDB;
import controller.ControllerListImpl;
import controller.LogerControllerProxy;
import controller.IControllerlist;
import utils.IOutilsImpl;

import java.io.IOException;

/**
 * Created by work on 17.09.2016.
 */
public class StartApp {



    public static void main(String[] args) throws AddContactException, IOException {

        IappDB iappDB =(IappDB) IOutilsImpl.loadObjFromFile();
        IControllerlist iControllerlist = new LogerControllerProxy(new ControllerListImpl(iappDB));

/*        iControllerlist.addContact("Sergey", "0677777777", "Sergey@gmail.com");
        iControllerlist.addContact("Alex", "0737373737", "Alex@gmail.com");
        iControllerlist.addContact("Ivan", "0733333333", "Ivan@gmail.com");
        iControllerlist.addContact("Elena", "0505050505", "Elena@gmail.com");
        iControllerlist.addContact("Anya", "0989898989", "Anya@gmail.com");
        iControllerlist.addContact("Yulya", "0636363636", "Yulya@gmail.com");
        iControllerlist.addContact("Senya", "0939393939", "Senya@gmail.com");*/

        new ViewMainFrame(iControllerlist);


    }

}
