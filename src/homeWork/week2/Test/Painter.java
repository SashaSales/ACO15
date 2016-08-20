package ACO15.GIT.src.ua.artcode.homeWork.week2.Test;

/**
 * Created by work on 17.08.2016.
 */
public class Painter extends Worker {
    String kind;

    Painter(String name, String kind) {
        super(name);
        this.kind = kind;
    }

    @Override
    public void work (){
        System.out.println("Painter work");
    }
}
