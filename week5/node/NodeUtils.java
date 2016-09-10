package ua.artcod.homeWork.week5.node;

import java.util.List;

/**
 * Created by work on 09.09.2016.
 */
public interface NodeUtils {

    void addToTail(Node first, Object val);

    Node addToHead(Node chain, Object val);

    String toString(Node chain);

    Node createNode(Object... mas);

    Node createNodeR(Object... mas);

    int count(Node chain);

    Node remove(Node chain, Object val);

    List<Object> toArray(Node chain);

    //reverse using loop
    Node reverse(Node curr);

    //reverse usin recursion
    Node reverse(Node curr, Node next, Node prev);

}
