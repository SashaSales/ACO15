package ua.artcode.classWork.week2.crm.utils;
import ua.artcod.classWork.week2.crm.model.Manager;
import java.util.Arrays;
/**
 * Created by work on 14.08.2016.
 */
public class Array {

    public static final int DEFAULT_ARRAY_SIZE = 16;

    private Object[] array;
    private int index;

    public Array() {
        array = new Object[DEFAULT_ARRAY_SIZE];
    }

    public Object get(int index){
        return array[index];
    }

    public void set(int index, Object obj){
        array[index] = obj;
    }

    public boolean add(Object obj){

        if(obj == null){
            return false;
        }

        ensureCapacity();
        array[index++] = obj;
        return true;
    }

    private void ensureCapacity() {
        if(index >= array.length){
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array,0,newArray,0,array.length);
            array = newArray;
        }
    }

    public Object[] getAll(){
        Object[] retArr = Arrays.copyOf(array, index);
        return retArr;
    }

}
