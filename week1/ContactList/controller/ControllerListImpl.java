package ua.artcod.homeWork.week1.ContactList.controller;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.model.Contact;
import ua.artcod.homeWork.week1.ContactList.validation.Validation;

import java.util.List;

/**
 * Created by work on 10.09.2016.
 */
public class ControllerListImpl implements IControllerlist {

    private List<Contact> contactList;
    private IappDB iappDB;
    //private Validation validation = new Validation(iappDB);

    public ControllerListImpl(IappDB iappDB) {
        this.iappDB = iappDB;
    }

    @Override
    public List<Contact> addContact(String name, String phoneNumber, String email) {

       /* validation.checkContactName(name);
        validation.checkContactPhoneNumber(phoneNumber);
        validation.checkContactEmail(email);*/

        String operator = Validation.Operator(phoneNumber);

        List<Contact> contactList = iappDB.addContact(name, phoneNumber, email, operator);

        return contactList;
    }

    @Override
    public Contact removeContact(int index) {

        Contact remove = iappDB.removeContact(index);
        return remove;
    }

    @Override
    public Contact removeContact(String name) {

        Contact remove = iappDB.removeContact(name);
        return remove;
    }

    @Override
    public void showAll() {

        iappDB.showAll();
    }

    @Override
    public void showFirstFiveContacts() {

        iappDB.showFirstFiveContacts();
    }

    @Override
    public void showLastFiveContacts() {

        iappDB.showLastFiveContacts();
    }

    @Override
    public void showLifeContacts() {
        iappDB.showLifeContacts();
    }

    @Override
    public void showKievstarContacts() {
        iappDB.showKievstarContacts();
    }

    @Override
    public void showMTSContacts() {
        iappDB.showMTSContacts();
    }

    @Override
    public Contact removeLast() {

        Contact remove = iappDB.removeLast();
        return remove;
    }

    @Override
    public Contact  findContact(String name) {

        Contact contact = iappDB.findContact(name);

        return contact;
    }

    @Override
    public Contact updateContactInfo(String name, String newName) {

        Contact contact = iappDB.updateContactInfo(name, newName);
        return contact;
    }

    @Override
    public List<Contact> getContactList() {

        contactList = iappDB.getContactList();
        return contactList;
    }

    @Override
    public List<Contact> getContactLife() {
        return null;
    }

    @Override
    public List<Contact> getContactKievstar() {
        return null;
    }
}
