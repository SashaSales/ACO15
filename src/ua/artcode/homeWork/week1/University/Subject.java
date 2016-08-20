package ACO15.GIT.src.ua.artcode.homeWork.week1.University;

/**
 * Created by work on 10.08.2016.
 */
public class Subject {

    public String nameSubject;
    public int qtyHoursSimestr;
    public int qtyUsedHoursStudent;
    public int mark;
    private String info;


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public void init(String nameSubject, int qtyHoursSimestr){
        this.nameSubject = nameSubject;
        this.qtyHoursSimestr = qtyHoursSimestr;
    }

    public String asString (){
        return String.format("Название предмета: %s, количество часов в семестре: %s", nameSubject, qtyHoursSimestr);
    }


}
