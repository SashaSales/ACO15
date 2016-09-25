package appDB;

import exceptions.RemoveContactException;
import model.Contact;

import java.io.IOException;
import java.io.Serializable;
import java.util.NavigableSet;

/**
 * Created by work on 10.09.2016.
 */
public interface IappDB extends Serializable {

    Contact removeContact(String name) throws RemoveContactException;
    NavigableSet<Contact> showAll();
    boolean addContact(String name, String phoneNumber, String email);
    NavigableSet<Contact> showLifeContacts();
    NavigableSet<Contact> showKievstarContacts();
    NavigableSet<Contact> showMTSContacts();
    Contact findContact(String name);
    Contact updateContactInfo(int id, Contact contactUpdate);
    NavigableSet<Contact> getContactList();
    NavigableSet<Contact> getContactLife();
    NavigableSet<Contact> getContactKievstar();
    NavigableSet<Contact> getContactMTS();
    boolean saveDB() throws IOException;
    IappDB loadDB() throws IOException;

}
