package ACO15.GIT.src.classWork.week1.Company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCompany {
    public static void main(String[] args) {
    User user1 = User.initUser(1, "name1", 25, 1300);

        String x = user1.asString();
        System.out.println(x);

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