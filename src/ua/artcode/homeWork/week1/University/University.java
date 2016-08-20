package ACO15.GIT.src.ua.artcode.homeWork.week1.University;


public class University {


   public Student [] students = new Student [5];
   public Subject [] subjects = new Subject[6];
    public int [][] qtyUsedHoursStudentSubject = new int[5][6];
    public int [][] markStudentSubject = new int [5][6];
    public int [] middleMark = new int[5];
    public int freeIndexStudent;
    public int freeIndexSubject;

    public Student [] addStudentToUniversity (Student student){

        if (student == null) {
            System.out.println("Null");
        }

        if (freeIndexStudent < students.length){
            students[freeIndexStudent] = student;
            freeIndexStudent++;
        }

        if ( freeIndexStudent == students.length){
            System.out.println("Память заполнена");
        }

        return students;
    }

    public Subject [] addSubjectToUniversity (Subject subject){

        if (subject == null) {
            System.out.println("Null");
        }
        if (freeIndexSubject < subjects.length){
            subjects[freeIndexSubject] = subject;
            freeIndexSubject++;
        }
        if ( freeIndexSubject == subjects.length){
            System.out.println("Память заполнена");
        }
        return subjects;
    }


    public void showAllStudentInUniversity (){
        String str = "";
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                str += students[i].asString() + "\n";
            } else str += "null \n";
        }
        System.out.println(str);
    }


    public void showAllSubjectInUniversity (){
        String str = "";
        for (int i = 0; i < students.length; i++) {
            if (subjects[i] != null){
                str += subjects[i].asString() + "\n";
            } else str += "null \n";
        }
        System.out.println(str);
    }

    public void showAllInfoOfSubjectInUniversity (){
        String str = "";
        for (int i = 0; i < students.length; i++) {
            if (subjects[i] != null){
                str += subjects[i].getInfo() + "\n";
            } else str += "null \n";
        }
        System.out.println(str);
    }

    public int[][] studyStudent(Student [] students, Subject [] subjects) {


        for (int i = 0; i < students.length; i++) {
            if (students [i] != null){
                for (int j = 0; j < subjects.length; j++) {
                     if (subjects [j] != null){
                         qtyUsedHoursStudentSubject [i][j] = (int)(subjects[j].qtyHoursSimestr *(1 - Math.random()));
                     } else break;
                }
            } else break;
        }
        return qtyUsedHoursStudentSubject;
    }


    public void showStudyStudents(){

        for (int i = 0; i < qtyUsedHoursStudentSubject.length; i++) {
            for (int j = 0; j < qtyUsedHoursStudentSubject[i].length; j++) {
                if (students[i] != null) {
                    if (subjects[j] != null){
                        System.out.println(students[i].name + " " + subjects[j].nameSubject + " количество проработанных часов " + qtyUsedHoursStudentSubject[i][j] + "\n");
                    } else break;
                } else break;
            }
        }
    }


    public int[][] examStudentSubject(Student [] students, Subject [] subjects) {


        for (int i = 0; i < students.length; i++) {
            if (students [i] != null){
                for (int j = 0; j < subjects.length; j++) {
                    if (subjects [j] != null){
                        markStudentSubject [i][j] = (int)(100 * Math.random());
                    } else break;
                }
            } else break;
        }
        return markStudentSubject;
    }


    public void showExamStudentSubject(){

        for (int i = 0; i < markStudentSubject.length; i++) {
            if (students [i] != null){
                    for (int j = 0; j < markStudentSubject[i].length; j++) {
                        if (subjects [j] != null){
                                if (markStudentSubject[i][j] > 39){
                                System.out.println(students[i].name + " " + subjects[j].nameSubject + " оценка по экзамену " + markStudentSubject[i][j] + "\n");
                                } else System.out.println(students[i].name + " " + subjects[j].nameSubject + " " + "False \n");
                        } else break;
                    }
            } else break;
        }

    }


    public int [] middleMarkStudentSubject(){
        int k = 0;
        int middle = 0;
        for (int i = 0; i < students.length; i++) {
            if (students [i] != null){
                for (int j = 0; j < subjects.length; j++) {
                    if (subjects [j] != null){
                        middle +=  markStudentSubject[i][j];
                        k++;
                    } else break;
                }
            } else break;
            middleMark[i] = middle/k;
            middle=0;
        }
        return middleMark;
    }

    public void showMiddleMarkStudent(){
        for (int i = 0; i < middleMark.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].name + " средний бал по предметам " + middleMark[i]);
            } else break;
        }
    }

}
