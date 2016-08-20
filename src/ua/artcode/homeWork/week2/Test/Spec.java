package ACO15.GIT.src.ua.artcode.homeWork.week2.Test;

/**
 * Created by work on 17.08.2016.
 */
public class Spec extends Worker {
    String type;
    Spec(String name, String type) {
        super(name);
        this.type = type;
    }

    @Override
    public void work (){
        System.out.println("Spec work");
    }

}
