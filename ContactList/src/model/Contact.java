package model;
import validation.Validation;

import java.io.Serializable;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by work on 09.08.2016.
 */
public class Contact implements Serializable, Comparator<Contact>, Comparable <Contact> {

  private int id;
  private String name;
  private String phoneNumber;
  private String email;
  private Adress adress;
  private String operatorLifeKievstarMTS;


    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.operatorLifeKievstarMTS = Validation.Operator(phoneNumber);

    }

    public Contact(String name, String phoneNumber, String email, Adress adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.operatorLifeKievstarMTS = Validation.Operator(phoneNumber);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getOperatorLifeKievstarMTS() {
        return operatorLifeKievstarMTS;
    }

    public void setOperatorLifeKievstar(String operatorLifeKievstarMTS) {
        this.operatorLifeKievstarMTS = operatorLifeKievstarMTS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name +"                 \n" +
                phoneNumber +"               \n" +
                 email + "\n";
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return phoneNumber != null ? phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        return phoneNumber != null ? phoneNumber.hashCode() : 0;
    }

    @Override
    public int compareTo(Contact o) {
        return this.getName().compareTo(o.getName());
    }
}
