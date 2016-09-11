package ua.artcod.homeWork.week1.ContactList.controller;

import ua.artcod.homeWork.week1.ContactList.model.Contact;

import java.util.List;

/**
 * Created by work on 10.09.2016.
 */
public interface IControllerlist {

    List<Contact> addContact(String name, String phoneNumber, String email);
    Contact removeContact(int index);
    Contact removeContact(String name);
    void showAll();
    void showFirstFiveContacts();
    void showLastFiveContacts();
    void showLifeContacts();
    void showKievstarContacts();
    void showMTSContacts();
    Contact removeLast ();
    Contact findContact(String name);
    Contact updateContactInfo (String name, String newName);
    List<Contact> getContactList();
    List<Contact> getContactLife();
    List<Contact> getContactKievstar();

}
