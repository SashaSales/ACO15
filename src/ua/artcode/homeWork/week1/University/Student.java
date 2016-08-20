package ACO15.GIT.src.ua.artcode.homeWork.week1.University;

/**
 * Created by work on 10.08.2016.
 */
public class Student {

   public String name;
   public Adress adress = new Adress();
   private int freeIndexSubject;



    Subject [] subjectsForStudents = new Subject[10];

    public void init(String name, Adress adress){
        this.name = name;
        this.adress = adress;
    }

    public String asString(){
        return String.format("Имя студента: %s, адресс: %s, %s, %s ", name, adress.city, adress.street, adress.houseNumber);
    }



   public Subject [] addSubject(Subject subject){


       if (subject == null){
           System.out.println("Ошибка");
       }

       if (freeIndexSubject < subjectsForStudents.length) {
           subjectsForStudents[freeIndexSubject] = subject;
           freeIndexSubject++;
       }

       if ( freeIndexSubject == subjectsForStudents.length){
           System.out.println("Память заполнена");
       }

       return subjectsForStudents;

   }


    public void showAllSubjectForStudent(){
        String str = "";
        for (int i = 0; i < subjectsForStudents.length; i++) {
            if (subjectsForStudents[i] != null){
                str += subjectsForStudents[i].asString() + "\n";
            } else {
                str += "null \n";
            }
        }
        System.out.println(str);
    }

    public Subject [] removeLastSubject(){

        for (int i = 1; i < subjectsForStudents.length; i++) {
            if (subjectsForStudents[i] == null) {
                subjectsForStudents[i-1] = null;
                break;
            }
        }

        return subjectsForStudents;
    }



}
