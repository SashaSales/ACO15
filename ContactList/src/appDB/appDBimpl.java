package appDB;

import exceptions.RemoveContactException;
import constants.Contstants;
import model.Contact;
import utils.IOutilsImpl;
import validation.Validation;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by work on 10.09.2016.
 */
public class appDBimpl implements IappDB, Serializable{

    private NavigableSet<Contact> contactList = new TreeSet<>();
    private IOutilsImpl ioUtils = new IOutilsImpl();
    private int freeIndex;

    public appDBimpl() {
    }

    @Override
    public boolean addContact(String name, String phoneNumber, String email){

        Contact contact = new Contact(name, phoneNumber, email);
        contact.setId(freeIndex++);

            return contactList.add(contact);
    }


    @Override
    public Contact removeContact(String name)  throws RemoveContactException {

        Contact contactForDelete = null;

        for (Contact contact : contactList) {
            if(contact.getName().equals(name)){
                contactForDelete = contact;
            }
        }

        boolean removeRes = contactList.remove(contactForDelete);

        if (removeRes) return contactForDelete;
        else {
            throw new RemoveContactException("Contact don`t remove from DB");
        }

    }


    @Override
    public NavigableSet<Contact> showAll() {

        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }

        return contactList;
    }


    @Override
    public NavigableSet<Contact> showLifeContacts() {

        NavigableSet<Contact> lifeContacts = getContactLife();

        for (Contact contactLife : lifeContacts) {
            System.out.println(contactLife.toString());
        }

        return lifeContacts;
    }

    @Override
    public NavigableSet<Contact> showKievstarContacts() {

        NavigableSet<Contact> kievstarContacts = getContactKievstar();

        for (Contact contactKievstar : kievstarContacts) {
            System.out.println(contactKievstar.toString());
        }

        return kievstarContacts;

    }

    @Override
    public NavigableSet<Contact> showMTSContacts() {

        NavigableSet<Contact> mtsContacts = getContactMTS();

        for (Contact contactMTS : mtsContacts) {
            System.out.println(contactMTS.toString());
        }

        return mtsContacts;

    }

    @Override
    public Contact findContact(String name) {

        Contact findContact = null;

        for (Contact contact : contactList) {
            if(contact.getName().equals(name)){
                findContact = contact;
            }
        }

        return findContact;
    }

    @Override
    public Contact updateContactInfo(int id, Contact contactUpdate) {

        for (Contact contact : contactList) {
            if(contact.getId() == id){
                contact.setName(contactUpdate.getName());
                contact.setAdress(contactUpdate.getAdress());
                contact.setEmail(contactUpdate.getEmail());
                contact.setOperatorLifeKievstar(Validation.Operator(contactUpdate.getPhoneNumber()));
                contact.setPhoneNumber(contactUpdate.getPhoneNumber());
            }
        }

        return contactUpdate;
    }

    @Override
    public NavigableSet<Contact> getContactList() {
        return contactList;
    }

    @Override
    public NavigableSet<Contact> getContactLife() {

        NavigableSet<Contact> lifeContacts = new TreeSet<>();

        for (Contact contact : contactList) {
            if(contact.getOperatorLifeKievstarMTS().equals("L")){
                lifeContacts.add(contact);
            }
        }

        return lifeContacts;
    }

    @Override
    public NavigableSet<Contact> getContactKievstar() {

        NavigableSet<Contact> kievstarContacts = new TreeSet<>();

        for (Contact contact : contactList) {
            if(contact.getOperatorLifeKievstarMTS().equals("K")){
                kievstarContacts.add(contact);
            }
        }

        return kievstarContacts;
    }

    @Override
    public NavigableSet<Contact> getContactMTS() {

        NavigableSet<Contact> mtsContacts = new TreeSet<>();

        for (Contact contact : contactList) {
            if(contact.getOperatorLifeKievstarMTS().equals("M")){
                mtsContacts.add(contact);
            }
        }

        return mtsContacts;
    }

    @Override
    public boolean saveDB() throws IOException{

        return IOutilsImpl.saveObjToFile(this);
    }

    public IappDB loadDB() throws IOException {

        IappDB appDB = (IappDB) IOutilsImpl.loadObjFromFile();
        return appDB;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Contact contact : contactList) {
            sb.append(contact.toString() + "\n");
        }

        return sb.toString();
    }
}
