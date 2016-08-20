package ACO15.GIT.src.ua.artcode.classWork.week1.Company;

/**
 * Created by work on 07.08.2016.
 */
public class Test {

       // start point
        public static void main(String[] args){

        //1
        int age = 23;
        String name = "Ivan";
        double salary = 2000.23;

        //3 types problem

        String[][] userTable = new String[10][3];
        String ageStrTable = userTable[0][1];

        //2 user is located in various arrays
        int size = 10;
        int[] ages = new int[size];
        String[] names = new String[size];
        double[] salaries = new double[size];

        names[0] = "Ivan";
        ages[0] = 28;
        salaries[0] = 1500;

                // use ROLE
                 // allocate memory(in heap) for class fields
                 // create instance (object)
        User user1 = new User(); // int, String, double
        user1.name = "Serhii";
        user1.age = 25;
        user1.salary = 3000;

        User user2 = new User(); // int, String, double
        user2.name = "Ania";
        user2.age = 28;
        user2.salary = 2000;

        }

}
