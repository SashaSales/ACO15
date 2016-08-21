package ua.artcode.classWork.week2.crm.test.utils;
import ua.artcod.classWork.week2.crm.model.Dev;
import ua.artcod.classWork.week2.crm.utils.Array;
/**
 * Created by work on 14.08.2016.
 */
public class TestArray {

    public static void main(String[] args) {
        Dev dev = new Dev("Ivan","ivan@gmail.com");

        Array array = new Array();

        boolean addActual = array.add(dev);
        boolean addExpected = true;

        System.out.printf("%s addMethod\n", (addExpected == addActual));

        boolean addNullActual = array.add(null);
        boolean addNullExpected = false;

        System.out.printf("%s addNull\n", addNullActual == addNullExpected);


        Dev getActual = (Dev) array.get(0);
        Dev getExpected = dev;

        System.out.printf("%s getMethod\n", (getActual.getId() == getExpected.getId()));



    }

}
