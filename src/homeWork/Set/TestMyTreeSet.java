package ua.artcod.classWork.week6.collections.Set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by work on 15.09.2016.
 */
public class TestMyTreeSet {

    public static void main(String[] args) {

        Set<Integer> treeSet = new MyTreeSet<>();

        treeSet.add(6);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(4);
        treeSet.add(12);
        treeSet.add(7);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(3);

        boolean res1 = treeSet.size() == 7;
        Iterator<Integer> iterator = treeSet.iterator();
        Object [] objs = treeSet.toArray();

        treeSet.remove(4);
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }



        /*for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i].toString());
        }*/

        //boolean res2 = MyTreeSet.


        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

  /*      for (Integer integer : treeSet) {
            System.out.println(integer);
        }*/

/*
     Integer value1 = iterator.next();
        Integer value2 = iterator.next();
        Integer value3 = iterator.next();
        Integer value4 = iterator.next();
        Integer value5 = iterator.next();
        Integer value6 = iterator.next();
        Integer value7 = iterator.next();
        Integer value8 = iterator.next();
        Integer value9 = iterator.next();
        Integer value10 = iterator.next();

        System.out.println(value1 + ","+ value2 +","+  value3 +","+  value4 +","+  value5 + ","+  value6 + ","+  value7 + ","+  value8 + ","+  value9 + ","+  value10);
*/

        //System.out.println(res1);

    }

}
