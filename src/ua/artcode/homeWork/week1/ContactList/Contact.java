package ACO15.GIT.src.ua.artcode.homeWork.week1.ContactList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by work on 09.08.2016.
 */
public class Contact {

  private String name;
  private String phoneNumber;
  private String email;
  private String operatorLifeKievstar;

    Contact(String name, String phoneNumber,  String email) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;



        if (!checkName() || !checkPhoneNumber() || !checkEmail()) {
            System.out.println("Не правильно введен контакт");
            this.name = null;
            this.phoneNumber = null;
            this.email = null;
        }

        String str = phoneNumber.substring(0,3);
        if (str.equals("063")||str.equals("093")||str.equals("073")){
            operatorLifeKievstar = "Life";
        } else if (str.equals("098")||str.equals("067")||str.equals("068")){
            operatorLifeKievstar = "Kievstar";
        } else operatorLifeKievstar = null;


    }


    public boolean checkName() {
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean checkPhoneNumber() {

        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    public boolean checkEmail(){
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,8}\\@(gmail|ukr|mail)\\.(com|net|ru)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public String toStringContact(){
        return "name: " + name + " phone: " + phoneNumber + " email: " + email;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOperatorLifeKievstar() {
        return operatorLifeKievstar;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOperatorLifeKievstar(String operatorLifeKievstar) {
        this.operatorLifeKievstar = operatorLifeKievstar;
    }

}
