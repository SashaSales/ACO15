package ua.artcod.homeWork.week5.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 09.09.2016.
 */
public class NodeUtilsImpl implements NodeUtils {
    @Override
    public void addToTail(Node first, Object val) {

        if (first.next == null){
            Node last = new Node (val, null);
            first.next = last;
            return;
        }

        addToTail(first.next, val);

    }

    @Override
    public Node addToHead(Node chain, Object val) {

        if (chain == null){
            chain = new Node(val, null);
        }

        Node newNode = new Node (val, chain);
        chain = newNode;

        return chain;
    }

    @Override
    public String toString(Node chain) {

        return chain != null ? chain.value.toString() + "->" + toString(chain.next) : "";
    }

    @Override
    public Node createNode(Object... mas) {
        int size = mas.length;
        Node head = new Node(mas[0], null);
        Node last = head;
        for (int i = 1; i < size; i++) {
            last.next = new Node(mas[i], null);
            last = last.next;
        }
        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {

        Node head = null;
        Node last = null;
        int i = 0;
        if (i == mas.length - 1){
            head = new Node(mas[i],null);
            return head;
        }

        head = new Node(mas[i], null);
        Object [] newMas = new Object[mas.length - 1];
        System.arraycopy(mas, 1, newMas, 0, newMas.length);
        head.next = createNodeR(newMas);

        return head;
    }

    @Override
    public int count(Node chain) {

        int i = 0;

        if (chain == null){
            return  0;
        }

        i = count(chain.next) + 1;
        return i;
    }

    @Override
    public Node remove(Node chain, Object val) {

        Node remove = null;

        if (chain == null){
            return null;
        }

        if (chain.value.equals(val)){
            remove = chain;
            chain = chain.next;
            return remove;
        }

        if (chain.next!= null) {
            if (chain.next.value.equals(val)) {
                remove = chain.next;
                chain.next = chain.next.next;
                return chain.next;
            }
        }
        return remove(chain.next, val);
    }

    @Override
    public List<Object> toArray(Node chain) {
        List<Object> obj = new ArrayList<>();
        while (chain != null){
            obj.add(chain.value);
            chain = chain.next;
        }

     return  obj;
    }

    @Override
    public Node reverse(Node curr) {

        if (curr == null){
            return null;
        }

        Node next = null;
        Node prev = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        return null;
    }
}
