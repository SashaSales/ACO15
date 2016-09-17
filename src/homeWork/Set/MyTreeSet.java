package ua.artcod.classWork.week6.collections.Set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by work on 13.09.2016.
 */
public class MyTreeSet<E> implements Set<E> {

    private TreeNode<E> root;
    private int size;




    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {

        Comparable<E> comparable = (Comparable<E>) o;

        return findNode(root, comparable) != null;
    }

    private TreeNode<E> findNode(TreeNode<E> curr, Comparable<E> val){

        if(curr == null){
            return null;
        }
            int compRes = val.compareTo(curr.val);
        if (compRes < 0){
            return findNode(curr.left, val);
        } else if (compRes > 0) {
            return findNode(curr.right, val);
        }
        return curr;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyTreeSetIterator();
    }

    @Override
    public Object[] toArray() {

        MyTreeSetIterator iterator =  new MyTreeSetIterator();
        Object [] objs = new Object[size];

        for (int i = 0; i < objs.length; i++) {
            objs[i] = iterator.next();
        }

        return objs;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        if(root == null){
            root = new TreeNode<E>(e, null, null, null);
            size++;
        }

            TreeNode<E> iter = root;
            Comparable<E> forCompare = (Comparable<E>) e;

            while (iter != null){
                int compareRes = forCompare.compareTo(iter.val);
                if(compareRes < 0){

                    if (iter.left == null){
                        iter.left = new TreeNode<E>(e, iter, null, null);
                        size ++;
                    }
                    iter = iter.left;


                } else if(compareRes >  0){
                    if (iter.right == null){
                        iter.right = new TreeNode<E>(e, iter, null, null);
                        size++;
                    }
                    iter = iter.right;


                } else return false;
            }

        return false;
    }

    @Override
    public boolean remove(Object o) {

        TreeNode curr = findNode(root, (Comparable) o);

        if (curr.right == null && curr.left == null){
            curr.val = null;
            return true;
        } else if (curr.left == null && curr.right != null){
            curr.parent = curr.right;
            curr.val = null;
            return true;
        } else if (curr.left != null && curr.right == null){
            curr.parent = curr.left;
            curr.parent = curr.right;
            curr.val = null;
            return true;
        } else if (curr.left != null && curr.right != null){
            TreeNode newLink = curr.right;
            while (newLink.left != null){
                newLink = newLink.left;
            } curr.val = newLink.val;
            curr = newLink;
            newLink = null;
            return true;

        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    private static class TreeNode<T>{

        T val;
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T val, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private class MyTreeSetIterator implements Iterator<E> {

        MyTreeSet.TreeNode<E> curr;

        public MyTreeSetIterator() {
            this.curr = root;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {

            if (curr == null){
                return null;
            }

            if (curr.left != null) {
                curr = curr.left;
            } else if (curr.right != null) {
                curr = curr.right;
            } else if (curr != curr.parent.right) {
                curr = curr.parent.right;
            } else {
                while (curr == curr.parent.right) {
                    if (curr.parent.parent == null) {
                        E res = curr.parent.val;
                        curr = null;
                        return res;
                    } else curr = curr.parent;
                }
                curr = curr.parent.right;
            }

            return curr.val;
        }
    }
}
