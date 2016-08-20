package ACO15.GIT.src.ua.artcode.homeWork.week2.Test;

/**
 * Created by work on 17.08.2016.
 */
public class Test {

    public static void main(String[] args) {

        //Worker worker1 = new Worker("Ivan");
        //worker1.work();

        Worker worker2 = new Spec("Ivan", "mehanic");
        worker2.work();

        Worker worker3 = new Painter("Ivan", "mehanic");
        worker3.work();

    }

}
