package ACO15.GIT.src.ua.artcode.homeWork.week1.ContactList;

/**
 * Created by work on 09.08.2016.
 */
public class Test {

    public static void main(String[] args) {

        ContactList contactList = new ContactList();

        Contact cont1 = new Contact("Ale_x4", "0677727174", "piskun@gmail.com");
        contactList.checkUniqueName(cont1.getName());
        contactList.addContact(cont1);

        Contact cont2 = new Contact("Ale_x3", "0737727173", "pi34@gmail.com");
        contactList.checkUniqueName(cont2.getName());
        contactList.addContact(cont2);

        Contact cont3 = new Contact("Ale343_x2", "0930927172", "pi3@gmail.com");
        contactList.checkUniqueName(cont3.getName());
        contactList.addContact(cont3);

        Contact cont4 = new Contact("Ale22323_x2", "0631117172", "pi3111@gmail.com");
        contactList.checkUniqueName(cont4.getName());
        contactList.addContact(cont4);

        Contact cont5 = new Contact("Ale2232311_x2", "0981117111", "pi311122@gmail.com");
        contactList.checkUniqueName(cont5.getName());
        contactList.addContact(cont5);

        Contact cont6 = new Contact("Al11_x1111", "0631111111", "pi31122@mail.ru");
        contactList.checkUniqueName(cont6.getName());
        contactList.addContact(cont6);


       // contactList.showAll();
       // System.out.println();
        //contactList.removeContact(3);
        //contactList.showAll();
        //contactList.showFirstFiveContacts();
        //System.out.println();
        //contactList.showLastFiveContacts();
       // System.out.println();
       // contactList.showLifeContacts();
       // contactList.showKievstarContacts();
       // System.out.println(contactList.findContact("Ale2232311_x2"));

        /*contactList.updateContactInfo("Al11_x1111","Иван");
        System.out.println(cont6.toStringContact());
        System.out.println();
*/

        //contactList.updateContactInfo(1, "Alya", "0975847694");
        //contactList.showAll();

    }

}
