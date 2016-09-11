package ua.artcod.homeWork.week1.ContactList.view;

import ua.artcod.homeWork.week1.ContactList.appDB.IappDB;
import ua.artcod.homeWork.week1.ContactList.appDB.appDBimpl;
import ua.artcod.homeWork.week1.ContactList.controller.ControllerListImpl;
import ua.artcod.homeWork.week1.ContactList.controller.IControllerlist;
import ua.artcod.homeWork.week1.ContactList.model.Contact;
import ua.artcod.homeWork.week1.ContactList.validation.Validation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by work on 11.09.2016.
 */
public class IView {

    private Scanner scanner;
    private IControllerlist iControllerlist;
    private Validation validation = new Validation(iControllerlist);
    private Contact contact;
    private appDBimpl iappDB;


    public IView(Scanner scanner) {
        this.scanner = scanner;
    }

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
        System.out.println("10.Сохранить контакт лист перед выходом");
    }

    public void showShortMenu() {
        System.out.println("Введите номер функции");
        System.out.println("1.Остаться в этом меню");
        System.out.println("2.Вернуться к предыдущему меню");
    }

    public void showMenuCreateContact() {

        System.out.println("Введите имя нового контакта");
        String name = scanner.nextLine();

        if (validation.checkContactName(name) == false) {
            while (validation.checkContactName(name) == false) {
                System.out.println("Введите имя нового контакта");
                name = scanner.nextLine();
            }
        }

        System.out.println("Введите номер телефона нового контакта");
        String phoneNumber = scanner.nextLine();

        if(validation.checkContactPhoneNumber(phoneNumber) == false) {
            while (validation.checkContactPhoneNumber(phoneNumber) == false) {
                System.out.println("Введите номер телефона нового контакта");
                phoneNumber = scanner.nextLine();
            }
        }

        System.out.println("Введите email нового контакта");
        String email = scanner.nextLine();

        if(validation.checkContactEmail(email) == false) {
            while (validation.checkContactEmail(email) == false) {
                System.out.println("Введите email нового контакта");
                email = scanner.nextLine();
            }
        }

        System.out.println("Новый контакт:");
        iControllerlist.addContact(name, phoneNumber, email);
        Contact contact = iControllerlist.findContact(name);
        System.out.println(contact.toString());
    }



    public void start() throws IOException {
        showMainMenu();
        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {

                showMenuCreateContact();

                showShortMenu();
                int secondchoice = -1;
                while ((secondchoice = Integer.parseInt(scanner.nextLine())) == 1) {
                    showMenuCreateContact();
                    showShortMenu();
                }
            } else if (choice == 2) {

                showRemoveContactMenu();
                showShortMenu();
                int secondchoice = -1;
                while ((secondchoice = Integer.parseInt(scanner.nextLine())) == 1) {
                    showRemoveContactMenu();;
                    showShortMenu();
                }

            } else if (choice == 3) {

                showUpdateContactMenu();
                showShortMenu();
                int secondchoice = -1;
                while ((secondchoice = Integer.parseInt(scanner.nextLine())) == 1) {
                    showRemoveContactMenu();
                    showShortMenu();
                }
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

            } else if (choice == 10) {
                iControllerlist.saveDB();
            }


            showMainMenu();
        }
    }

    private void showUpdateContactMenu() {

        System.out.println("Введите имя котакта для редактирования данных");
        String name = scanner.nextLine();
        System.out.println("Введите имя котакта для редактирования данных");
        String newName = scanner.nextLine();
        iControllerlist.updateContactInfo(name, newName);
    }

    private void showRemoveContactMenu() {

        System.out.println("Введите имя котакта для удаления со списка");
        String name = scanner.nextLine();
        iControllerlist.removeContact(name);

    }


    public String pathForDatabase() throws IOException {

        System.out.println(" Выберете место для хранения базы данных: ");
        System.out.println("1. Сохранять ДБ по дефолтному пути: temp/MyDB.txt");
        System.out.println("2. Выбрать свой путь сохранения базы данных");
        System.out.println("3. Создать новую директорию");
        System.out.println("4. Создать файл с именем");

        String path = null;

        int choice = -1;
        while ((choice = Integer.parseInt(scanner.nextLine())) != 0) {
            if (choice == 1) {
                path = "temp/myDB.txt";
                System.out.println("Путь сохранения базы данных" + path);
                return path;

            }

        }
        System.out.println("Путь сохранения базы данных: " + path != null ? path : null);
        return path;
    }

}


