package ACO15.GIT.src.classWork.week1.Company;

public class Company {

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