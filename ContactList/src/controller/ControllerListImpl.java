package controller;

import exceptions.AddContactException;
import exceptions.ContactNullPointerException;
import exceptions.RemoveContactException;
import exceptions.WordIsEmpty;
import appDB.IappDB;
import model.Contact;
import utils.IOutils;
import utils.IOutilsImpl;

import java.io.IOException;
import java.io.Serializable;
import java.util.NavigableSet;

/**
 * Created by work on 10.09.2016.
 */
public class ControllerListImpl implements IControllerlist, Serializable{

    private IappDB iappDB;

    public ControllerListImpl(IappDB iappDB) {
        this.iappDB = iappDB;
    }

    @Override
    public boolean addContact(String name, String phoneNumber, String email) throws AddContactException {

       /* validation.checkContactName(name);
        validation.checkContactPhoneNumber(phoneNumber);
        validation.checkContactEmail(email);*/

        boolean contactRes = iappDB.addContact(name, phoneNumber, email);

        if (!contactRes) {
            throw new AddContactException("Contact don`t add to DB");
        } else {
            return contactRes;
        }

    }




    @Override
    public Contact removeContact(String name) throws RemoveContactException {

        return iappDB.removeContact(name);
    }

    @Override
    public NavigableSet<Contact> showAll() {

        return iappDB.showAll();
    }

    @Override
    public NavigableSet<Contact> showLifeContacts() {
        return iappDB.showLifeContacts();
    }

    @Override
    public NavigableSet<Contact> showKievstarContacts() {

        return iappDB.showKievstarContacts();
    }

    @Override
    public NavigableSet<Contact> showMTSContacts() {
        return  iappDB.showMTSContacts();
    }

    @Override
    public Contact findContact(String name) throws WordIsEmpty {

        if (name.isEmpty()){
            throw new WordIsEmpty("WordIsEmpty, please write correct Name");
        }

        Contact contact = iappDB.findContact(name);

        return contact;
    }

    @Override
    public Contact updateContactInfo(int id, Contact contactUpdate) throws ContactNullPointerException{

        if (contactUpdate == null){
            throw new ContactNullPointerException("Contact is null, please write correct Contact");
        }

        return iappDB.updateContactInfo(id, contactUpdate);
    }

    @Override
    public NavigableSet<Contact> getContactList() {

        return iappDB.getContactList();
    }

    @Override
    public NavigableSet<Contact> getContactLife() {
        return iappDB.getContactLife();
    }

    @Override
    public NavigableSet<Contact> getContactKievstar() {
        return iappDB.getContactKievstar();
    }

    @Override
    public NavigableSet<Contact> getContactMTS() {
        return iappDB.getContactMTS();
    }

    @Override
    public boolean saveDB() throws IOException {

        return iappDB.saveDB();
    }

    @Override
    public IappDB loadDB() throws IOException {

        return iappDB.loadDB();
    }

    @Override
    public String toString() {

        return iappDB.toString();
    }

    public IappDB getIappDB() {
        return iappDB;
    }
}
