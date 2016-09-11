package ua.artcod.homeWork.week1.ContactList.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by work on 09.08.2016.
 */
public class Contact {

  private int id;
  private String name;
  private String phoneNumber;
  private String email;
  private Adress adress;
  private String operatorLifeKievstarMTS;

    public Contact() {
    }

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(String name, String phoneNumber, String email, Adress adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
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
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
