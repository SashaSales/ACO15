package ua.artcod.homeWork.week5.node;

import java.util.List;

/**
 * Created by work on 09.09.2016.
 */
public class TestNodeUtils {

    public static void main(String[] args) {

    NodeUtils nodeUtils = new NodeUtilsImpl();
        Node head = nodeUtils.createNodeR(1,2,3,4,5);
        System.out.println(nodeUtils.toString(head));

        nodeUtils.addToTail(head, 6);
        System.out.println(nodeUtils.toString(head));

        Node newHead = nodeUtils.addToHead(head, 0);
        System.out.println(nodeUtils.toString(newHead));

        System.out.println(nodeUtils.count(newHead));

        Node remove = nodeUtils.remove(newHead,5);
        System.out.println(nodeUtils.toString(newHead));

        /*List<Object> objects = nodeUtils.toArray(newHead);
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i) + ",");
        }*/

        Node reverse = nodeUtils.reverse(newHead);
        System.out.println(nodeUtils.toString(reverse));

    }

}
