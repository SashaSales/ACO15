
package validation;

import exceptions.WordIsEmpty;
import appDB.IappDB;
import controller.IControllerlist;
import model.Contact;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation implements Serializable {

    private IappDB iappDB;
    private List<Contact> contactList;
    private IControllerlist iControllerlist;

/*    public Validation(IappDB iappDB) {
        this.iappDB = iappDB;
    }*/

    public Validation(IControllerlist iControllerlist) {
        this.iControllerlist = iControllerlist;
    }


    static void checkUniqueName(IControllerlist iControllerlist, String name) throws WordIsEmpty {

        Contact contact = iControllerlist.findContact(name);
        if (contact != null) {
            System.out.println("Контакт с таким именем уже существует, введие другое имя");
        }
    }

    public static String Operator(String phoneNumber) {

        String operatorLifeKievstarMTS = "none";

        if (phoneNumber.substring(0,3).equals("063") ||
                phoneNumber.substring(0,3).equals("093") ||
                    phoneNumber.substring(0,3).equals("073")){
            operatorLifeKievstarMTS = "L";
        } else if (phoneNumber.substring(0,3).equals("097") ||
                phoneNumber.substring(0,3).equals("067") ||
                phoneNumber.substring(0,3).equals("098")){
            operatorLifeKievstarMTS = "K";
        } else if (phoneNumber.substring(0,3).equals("050") ||
                phoneNumber.substring(0,3).equals("095") ||
                phoneNumber.substring(0,3).equals("099")){
            operatorLifeKievstarMTS = "M";
        }

        return operatorLifeKievstarMTS;
    }


    public boolean checkContactName(String name) {

        if (!checkName(name)) {
            System.out.println("Не правильно введено имя");
        }

        return checkName(name);
    }

    public boolean checkContactPhoneNumber(String phoneNumber) {

        if (!checkPhoneNumber(phoneNumber)) {
            System.out.println("Не правильно введен номер телефона");
        }

        return checkPhoneNumber(phoneNumber);
    }

    public boolean checkContactEmail(String email) {

        if (!checkEmail(email)) {
            System.out.println("Не правильно введен email");
        }

        return checkEmail(email);
    }

    public boolean checkName(String name) {
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean checkPhoneNumber(String phoneNumber) {

        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    public boolean checkEmail(String email){
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,8}\\@(gmail|ukr|mail)\\.(com|net|ru)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }


}

