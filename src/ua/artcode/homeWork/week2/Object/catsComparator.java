package ACO15.GIT.src.ua.artcode.homeWork.week2.Object;


import java.util.Comparator;

/**
 * Created by work on 18.08.2016.
 */
public class catsComparator implements Comparator<Cat> {


    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
