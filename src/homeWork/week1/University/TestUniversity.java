package ACO15.GIT.src.ua.artcode.homeWork.week1.University;

/**Поля класса делай private и делай метод гетеры и сеттеры - get, set

 public class Student {
 = new Subject[10]; лучше 10ть сделать константой или же передавать через параметр в конструкторе
 public Subject [] removeLastSubject(){ / / в этом методе можно использовать поле private int freeIndexSubject; Если я все правильно понял

 public class Subject { // тут можно добавить конструктор а метод init заменить на гетры и сетеры

 public class University {
 // тут ты во многие методы передаешь students и subjects они являются полями объекта и уже доступны из всех нестатических методов этого объекта. т.е. код можно немного упростить и оптимизировать.
 из public int[][] studyStudent(Student [] students, Subject [] subjects) -в >
 public int[][] studyStudent() а в методе свободно можно обращаться к этим переменным student и subject*/

public class TestUniversity {



    public static void main(String[] args) {

        University university = new University();

        Subject mathematics = new Subject();
        mathematics.init("Mathematics", 320);
        System.out.println(mathematics.asString());
        mathematics.setInfo("Математика структурах, порядке и отношениях, исторически сложившаяся на основе операций подсчёта, измерения и описания формы объектов");
        university.addSubjectToUniversity(mathematics);

        Subject english = new Subject();
        english.init("English", 160);
        System.out.println(english.asString());
        english.setInfo("Английский язык является важнейшим языком международного общения, торговли, сотрудничества и бизнеса");
        university.addSubjectToUniversity(english);

        Subject ukrainian = new Subject();
        ukrainian.init("Ukrainian", 158);
        System.out.println(ukrainian.asString());
        ukrainian.setInfo("Украинский язык — язык, распространён в юго-восточной Европе, относится к славянской группе индоевропейской языковой семьи. ");
        university.addSubjectToUniversity(ukrainian);

        Student student1 = new Student();
        Adress adress1 = new Adress();
        adress1.init("Volchansk", "Lenina", "34");
        student1.init("Andrey", adress1);
        System.out.println(student1.asString());
        university.addStudentToUniversity(student1);

        student1.addSubject(mathematics);
        student1.addSubject(english);
        student1.addSubject(ukrainian);
        System.out.println();
        System.out.println();
       // student1.showAllSubjectForStudent();

       // university.showAllStudentInUniversity();
        //university.showAllSubjectInUniversity();
       // university.showAllInfoOfSubjectInUniversity();

        university.studyStudent(university.students, university.subjects);

        university.showStudyStudents();

        university.examStudentSubject(university.students, university.subjects);
        university.showExamStudentSubject();
        university.middleMarkStudentSubject();
       university.showMiddleMarkStudent();

    }

}
