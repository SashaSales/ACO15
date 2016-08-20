package ACO15.GIT.src.ua.artcode.classWork.week1.Company;

public class User {

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