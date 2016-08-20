package ACO15.GIT.src.ua.artcode.homeWork.week1.ContactList;


public class ContactList {
    private int sizeContactList = 6;
    private Contact [] contactList = new Contact[sizeContactList];
    private Contact [] contactLife = new Contact[sizeContactList];
    private Contact [] contactKievstar = new Contact[sizeContactList];
    private int freeContactIndex = 0;


    public void checkUniqueName(String name) {

        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] != null) {
                if (contactList[i].getName().equals(name)) {
                    System.out.println("Контакт с таким именем уже существует");
                    break;
                }
            } else break;
        }
    }


    public Contact[] addContact(Contact contact){

        if (contact == null){
            System.out.println("Ошибка");
            return  null;
        } else if (freeContactIndex < contactList.length - 1) {
            contactList[freeContactIndex] = contact;
            freeContactIndex++;
        } else if ( freeContactIndex == contactList.length-1){
            contactList[freeContactIndex] = contact;
            System.out.println("Память заполнена");
            freeContactIndex++;
        } else if ( freeContactIndex == contactList.length){
            System.out.println("Память заполнена, данный конакт не добавлен в список");
            return  null;
        }

        return contactList;
    }

    public Contact [] removeContact(int index){

        if (index < 0 && index >= contactList.length) {
            return null;
        }

        contactList [index] = null;

        for (int i = index; i < contactList.length - 1; i++) {
            contactList [i] = contactList [i+1];
            if (contactList [i+1] == null) {
                contactList[i] = null;
            }
        }
        contactList [contactList.length - 1] = null;
        return contactList;
    }


    public void showAll(){

        String str = "";
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] != null) {
                str += contactList[i].toStringContact() + "\n";
            } else {
                str += " null \n";
            }

        }
        System.out.println(str);

    }

    public void showFirstFiveContacts(){

        String str = "";
        for (int i = 0; i < 5; i++) {
            if (contactList[i] != null) {
                str += contactList[i].toStringContact() + "\n";
            } else {
                str += " null \n";
            }
        }
        System.out.println(str);
    }

    public void showLastFiveContacts(){
        int lastIndexContact=0;
        String str = "";
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i] == null) {
                lastIndexContact = i-1;
                break;
            } else lastIndexContact = contactList.length -1;
        }
        for (int i = lastIndexContact-4; i < lastIndexContact + 1; i++) {
                str += contactList[i].toStringContact() + "\n";
        }

        System.out.println(str);
    }

    public void showLifeContacts(){
        String str = "";
        int indexLifeContact = 0;

        for (int i = 0; i < contactList.length; i++) {

                if (contactList[i].getOperatorLifeKievstar().equals("Life")) {
                    contactLife[indexLifeContact] = contactList[i];
                    str += contactLife[indexLifeContact].toStringContact() + "\n";
                    indexLifeContact++;
                } else if (contactList [i] == null) break;
        }
        System.out.println(str);
    }


    public void showKievstarContacts(){
        String str = "";
        int indexKievstarContact = 0;

        for (int i = 0; i < contactList.length; i++) {

            if (contactList[i].getOperatorLifeKievstar().equals("Kievstar")) {
                contactKievstar[indexKievstarContact] = contactList[i];
                str += contactKievstar[indexKievstarContact].toStringContact() + "\n";
                indexKievstarContact++;
            } else if (contactList [i] == null) break;
        }
        System.out.println(str);
    }


    public Contact [] removeLast () {

        contactList[freeContactIndex-1] = null;

        /*for (int i = 1; i < contactList.length; i++) {
            if (contactList[i] == null) {
                contactList[i-1] = null;
            } else contactList[contactList.length-1] = null;
        }*/
        return contactList;
    }


    public String findContact(String name){
        int indexFoundContact = 0;
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i].getName().equals(name)) {
                indexFoundContact = i;
                break;
            }
        }

        return  "name: " + contactList[indexFoundContact].getName() + "phone: " + contactList[indexFoundContact].getPhoneNumber() + "email: " + contactList[indexFoundContact].getEmail();
    }

    public Contact updateContactInfo (String name, String newName){
        int k = 0;
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i].getName().equals(name)) {
                k = i;
                break;
            }
        }
        contactList[k].setName(newName);
       return contactList[k];
    }

    public Contact updateContactInfo(int index, String newName, String newPhoneNumber){
        index--;
        contactList[index].setName(newName);
        contactList[index].setPhoneNumber(newPhoneNumber);
        return contactList[index];
    }


    public int getSizeContactList() {
        return sizeContactList;
    }

    public Contact[] getContactList() {
        return contactList;
    }

    public Contact[] getContactLife() {
        return contactLife;
    }

    public Contact[] getContactKievstar() {
        return contactKievstar;
    }

    public int getFreeContactIndex() {
        return freeContactIndex;
    }

}
