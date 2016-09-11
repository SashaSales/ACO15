package ua.artcod.homeWork.week1.ContactList.view;

import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.model.Contact;
import ua.artcod.homeWork.week1.ContactList.validation.Validation;

import java.util.Scanner;

/**
 * Created by work on 11.09.2016.
 */
public class IView {

    private Scanner scanner;
    private IControllerlist iControllerlist;
    private Validation validation = new Validation(iControllerlist);
    private Contact contact;

    public IView(Scanner scanner, IControllerlist iControllerlist) {
        this.scanner = scanner;
        this.iControllerlist = iControllerlist;
    }

    public void showMainMenu() {
        System.out.println("Введите номер функции");
        System.out.println("1.Создать контакт");
        System.out.println("2.Удалить контакт");
        System.out.println("3.Редактировать контакт");
        System.out.println("4.Показать все контакты");
        System.out.println("5.Показать все контакты оператора Life");
        System.out.println("6.Показать все контакты оператора Kievstar");
        System.out.println("7.Показать все контакты оператора MTS");
        System.out.println("8.Показать первые 5 контактов");
        System.out.println("9.Показать последние 5 контактов");
    }

    public void showMenuCreateContact() {

        System.out.println("Введите имя");
        String name = scanner.nextLine();

        if (validation.checkContactName(name) == false) {
            while (validation.checkContactName(name) == false) {
                System.out.println("Введите имя");
                name = scanner.nextLine();
            }
        }

        System.out.println("Введите номер телефона");
        String phoneNumber = scanner.nextLine();

        if(validation.checkContactPhoneNumber(phoneNumber) == false) {
            while (validation.checkContactPhoneNumber(phoneNumber) == false) {
                System.out.println("Введите номер телефона");
                phoneNumber = scanner.nextLine();
            }
        }

        System.out.println("Введите email");
        String email = scanner.nextLine();

        if(validation.checkContactEmail(email) == false) {
            while (validation.checkContactEmail(email) == false) {
                System.out.println("Введите email");
                email = scanner.nextLine();
            }
        }

        System.out.println("Контакт:");
        iControllerlist.addContact(name, phoneNumber, email);
        Contact contact = iControllerlist.findContact(name);
        System.out.println(contact.toString());
    }



    public void start() {
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                showMenuCreateContact();

            } else if (choice == 2) {

                System.out.println("Введите имя");
                String name = scanner.nextLine();
                iControllerlist.removeContact(name);

            } else if (choice == 4) {
                iControllerlist.showAll();

            } else if (choice == 5) {
                iControllerlist.showLifeContacts();

            } else if (choice == 6) {
                iControllerlist.showKievstarContacts();

            } else if (choice == 7) {
                iControllerlist.showMTSContacts();

            } else if (choice == 8) {
                iControllerlist.showFirstFiveContacts();

            } else if (choice == 9) {
                iControllerlist.showLastFiveContacts();

            }


            showMainMenu();
        }
    }
}


