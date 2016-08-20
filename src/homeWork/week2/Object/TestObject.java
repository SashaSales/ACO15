package ACO15.GIT.src.ua.artcode.homeWork.week2.Object;

import java.util.Arrays;

/**
 * Created by work on 18.08.2016.
 */
public class TestObject {

    public static void main(String[] args) {

        Cat [] cats = new Cat[3];


        System.out.println();
        cats[0] = new Cat(1, "Vasya", 5.2);
        cats[1] = new Cat(3, "Alya", 2.2);
        cats[2] = new Cat(2, "Sala", 3.2);

       /* Arrays.sort(cats);
        String res = Arrays.toString(cats);
        res = res.replaceAll("\\}", "\\}\n");
        System.out.println(res);*/

        Arrays.sort(cats, new catsComparator());
        String res = Arrays.toString(cats);
        res = res.replaceAll("\\}", "\\}\n");
        System.out.println(res);

    }

}


class Cat implements Comparable<Cat>{


    private int index;
    private String name;
    private double weight;

    @Override
    public String toString() {
        return "Cat{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Cat(int index, String name, double weight) {
        this.index = index;
        this.name = name;
        this.weight = weight;
    }



    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    /*@Override
    public int compareTo(Object o) {
        Cat other = (Cat) o;
        return this.index - other.index;
    }*/

    @Override
    public int compareTo(Cat o) {
        return index - o.index;
    }
}

