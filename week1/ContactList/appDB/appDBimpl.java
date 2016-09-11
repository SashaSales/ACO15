package ua.artcod.homeWork.week1.ContactList.appDB;

import ua.artcod.homeWork.week1.ContactList.model.Contact;
import ua.artcod.homeWork.week1.ContactList.utils.IOutils;
import ua.artcod.homeWork.week1.ContactList.utils.IOutilsImpl;
import ua.artcod.homeWork.week1.ContactList.validation.Validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 10.09.2016.
 */
public class appDBimpl implements IappDB, Serializable{

    private List<Contact> contactList = new ArrayList<>();
    private int freeIndexContact;
    private IOutilsImpl ioUtils = new IOutilsImpl();

    public String DB_PATH;

    public appDBimpl() {
    }

    public appDBimpl(String DB_PATH) {
        this.DB_PATH = DB_PATH;
    }

    @Override
    public List<Contact> addContact(String name, String phoneNumber, String email, String operator) {

        Contact contact = new Contact(name, phoneNumber, email);
        contact.setOperatorLifeKievstar(operator);
        contact.setId(freeIndexContact++);
        contactList.add(contact);

        //validation
        //metka operatora Life/KS/MTS

        return contactList;
    }

    @Override
    public Contact removeContact(int index) {

        Contact remove = contactList.remove(index);
        return remove;
    }

    @Override
    public Contact removeContact(String name) {

        Contact contact = null;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)){
                contact = contactList.get(i);
                contactList.remove(i);
            }
        }

        return contact;
    }


    @Override
    public void showAll() {

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).toString());
        }
    }

    @Override
    public void showFirstFiveContacts() {

        for (int i = 0; i < 5; i++) {
            System.out.println(contactList.get(i).toString());
        }
    }

    @Override
    public void showLastFiveContacts() {

        for (int i = contactList.size() - 5; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).toString());
        }
    }

    @Override
    public void showLifeContacts() {

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getOperatorLifeKievstarMTS().equals("L")){
                System.out.println(contactList.get(i).toString());
            }
        }

    }

    @Override
    public void showKievstarContacts() {

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getOperatorLifeKievstarMTS().equals("K")){
                System.out.println(contactList.get(i).toString());
            }
        }

    }

    @Override
    public void showMTSContacts() {

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getOperatorLifeKievstarMTS().equals("M")){
                System.out.println(contactList.get(i).toString());
            }
        }

    }

    @Override
    public Contact removeLast() {

        Contact remove = contactList.remove(--freeIndexContact);
        return remove;
    }

    @Override
    public Contact findContact(String name) {

        Contact contact = null;

        if (name.isEmpty()){
            System.out.println("Введите имя для поиска");
        }

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)){
                contact = contactList.get(i);
            }
        }

        return contact;
    }

    @Override
    public Contact updateContactInfo(String name, String newName) {

        Contact contact = null;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)){
                contactList.get(i).setName(newName);
                contact = contactList.get(i);
            }
        }
        return contact;
    }

    @Override
    public List<Contact> getContactList() {
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

    @Override
    public void saveDB() throws IOException{

        ioUtils.saveObjToFile(this, DB_PATH);
        /*for (int i = 0; i < contactList.size(); i++) {
            ioUtils.saveObjToFile(contactList.get(i), DB_PATH);
        }*/

    }

    public IappDB loadDB(String path) throws IOException {

        IappDB appDB = (appDBimpl) IOutilsImpl.loadObjFromFile(DB_PATH);
        return appDB;
    }
}
