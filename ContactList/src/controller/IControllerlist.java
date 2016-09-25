package controller;

import exceptions.AddContactException;
import exceptions.ContactNullPointerException;
import exceptions.RemoveContactException;
import exceptions.WordIsEmpty;
import appDB.IappDB;
import model.Contact;

import java.io.IOException;
import java.util.NavigableSet;

/**
 * Created by work on 10.09.2016.
 */
public interface IControllerlist {

    boolean addContact(String name, String phoneNumber, String email) throws AddContactException, IOException;

    Contact removeContact(String name) throws RemoveContactException, IOException;
    NavigableSet<Contact> showAll() throws IOException;
    NavigableSet<Contact> showLifeContacts();
    NavigableSet<Contact> showKievstarContacts();
    NavigableSet<Contact> showMTSContacts();
    Contact findContact(String name) throws WordIsEmpty;
    Contact updateContactInfo(int id, Contact contactUpdate) throws ContactNullPointerException;
    NavigableSet<Contact> getContactList();
    NavigableSet<Contact> getContactLife();
    NavigableSet<Contact> getContactKievstar();
    NavigableSet<Contact> getContactMTS();
    boolean saveDB() throws IOException;
    IappDB loadDB() throws IOException;
    IappDB getIappDB();

}
