package controller;

import exceptions.AddContactException;
import exceptions.ContactNullPointerException;
import exceptions.RemoveContactException;
import exceptions.WordIsEmpty;
import appDB.IappDB;
import logger.LoggerContainer;
import model.Contact;

import java.io.IOException;
import java.io.Serializable;
import java.util.NavigableSet;

/**
 * Created by work on 22.09.2016.
 */
public class LogerControllerProxy implements IControllerlist, Serializable{

    private IControllerlist originalControllerlist;

    public LogerControllerProxy(IControllerlist originalControllerlist) {
        this.originalControllerlist = originalControllerlist;
    }

    @Override
    public boolean addContact(String name, String phoneNumber, String email) throws AddContactException, IOException {

        String event = "Add contact: " + "name - " + name + "  phone - " + phoneNumber + "  email - " + email;
        LoggerContainer.logEvent(event);

        return originalControllerlist.addContact(name, phoneNumber, email);
    }


    @Override
    public Contact removeContact(String name) throws RemoveContactException, IOException {

        String event = "Remove contact by name: " + name;
        LoggerContainer.logEvent(event);

        return originalControllerlist.removeContact(name);
    }

    @Override
    public NavigableSet<Contact> showAll() throws IOException {

        String event = "Show All contacts ";
        LoggerContainer.logEvent(event);

        return originalControllerlist.showAll();
    }

    @Override
    public NavigableSet<Contact> showLifeContacts() {
        return originalControllerlist.showLifeContacts();
    }

    @Override
    public NavigableSet<Contact> showKievstarContacts() {
        return originalControllerlist.showKievstarContacts();
    }

    @Override
    public NavigableSet<Contact> showMTSContacts() {
        return originalControllerlist.showMTSContacts();
    }

    @Override
    public Contact findContact(String name) throws WordIsEmpty {
        return originalControllerlist.findContact(name);
    }

    @Override
    public Contact updateContactInfo(int id, Contact contactUpdate) throws ContactNullPointerException {
        return originalControllerlist.updateContactInfo(id, contactUpdate);
    }

    @Override
    public NavigableSet<Contact> getContactList() {
        return originalControllerlist.getContactList();
    }

    @Override
    public NavigableSet<Contact> getContactLife() {
        return originalControllerlist.getContactLife();
    }

    @Override
    public NavigableSet<Contact> getContactKievstar() {
        return originalControllerlist.getContactKievstar();
    }

    @Override
    public NavigableSet<Contact> getContactMTS() {
        return originalControllerlist.getContactMTS();
    }

    @Override
    public boolean saveDB() throws IOException {
        return originalControllerlist.saveDB();
    }

    @Override
    public IappDB loadDB() throws IOException {
        return originalControllerlist.loadDB();
    }

    @Override
    public IappDB getIappDB() {
        return originalControllerlist.getIappDB();
    }


}
