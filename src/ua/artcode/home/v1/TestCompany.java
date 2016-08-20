package ua.artcode.home.v1;

/**
 * Created by serhii on 07.08.16.
 */
/*
Ланцюжок повідомлень відкритий. 1 непрочитане повідомлення.

Перейти до вмісту
Using Gmail with screen readers
1
Пошук



Gmail
НАПИСАТИ
Мітки
Вхідні (146)
Із зірочкою
Надіслані
Чернетки (31)
покупон
artcode req
Більше міток
Hangouts




  Більше
3 з 781

Друкувати все У новому вікні
home work
Вхідні
x

Саша Масловський
Вкладені файли11:07 (5 хвилин тому)

кому мені
Область вкладених файлів

Натисніть тут, щоб вибрати: Відповісти або Переслати
Використано 3,83 Гб (22%) з 17 Гб
Керувати
Умови - Конфіденційність
Остання дість в обліковому записі: 15 хвилин тому
Деталі*/


import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by pc on 06.08.2016.
 */

public class TestCompany {
    public static void main(String[] args) {
        User user1 = User.initUser(1, "name1", 25, 1300);

        String x = user1.asString();
        System.out.println(x);


        String s2 = "Oleg";

        char[] chars = s2.toCharArray();
        String str = String.valueOf(234);


        User user2 = new User();
        user2.initUserNS(2, "name2", 30, 1500);

        Company company = new Company();

        company.addUser(user1);
        company.addUser(user2);

        company.showUsers();
        company.removeUser(user1);

        company.showUsers();

        // time point(long millis) 1970 - present
        Date date = new Date();
        date.getYear();
        date.getMonth();

        //Calendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int year = gregorianCalendar.get(Calendar.YEAR);
        int month = gregorianCalendar.get(Calendar.MONTH);

        // since java8
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.getYear();
        localDateTime.get(ChronoField.SECOND_OF_DAY);
        System.out.println(localDateTime);



    }

}

class Company {

    private User[] users = new User[10];


    public User[] addUser(User newUser){

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = newUser;
                break;
            }
        }
        return users;
    }

    public User[] removeUser(User user){
        for (int i = 0; i < users.length; i++) {

            // return users[i] == user ? users[i] = null : "user doesn`t exist";
            if (users[i] == user) {
                users[i] = null;
                break;
            } else {
                System.out.println("user doesn`t exist");
            }
        }
        return users;
    }

    public void showUsers(){
        String str = "";
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                str += users[i].asString() + "\n";
            } else {
                str += " null \n";
            }

        }
        System.out.println(str);
    }

}

// class -> fields and methods
class User {

    // field -> object
    public int id;
    public String name;
    public int age;
    public double salary;

    public static User initUser(int id, String name, int age, double salary){
        User user1 = new User();
        user1.age = age;
        user1.id = id;
        user1.name = name;
        user1.salary = salary;
        return user1;
    }

    public void initUserNS(int id, String name, int age, double salary){
        User self = this;
        self.age = age;
        self.id = id;
        this.name = name;
        self.salary = salary;
    }

    public String asString(){
        // formatter

        String resF = String.format("id %d, name %s, age %d, sal %.3f",
                id, name, age, salary);
        // name %s, age %d, salary %.2f,
        //    "Ivan", 25, 2000.23

        return resF;
    }

}
