package ArrayDS;

import java.util.Arrays;

// generic stack queue implementation any type can be used.
public class StackArray<E> implements ArrayDSInterface {

    private Object array[];
    private int size;

    public StackArray(int size) {

        this.array = new Object[size];
        this.size = 0;
    }

    // this by contract means THIS E is the E I am talking about in StackArray<E>
    // User can only add generic
    // specified at runtime
    public void push(E E) {
        if (!isFull()) {
            array[size] = E;
            size++;
        }
        /*
         * if(E.getClass() == String.class)
         * System.out.println("String");
         * if(E.getClass()== Integer.class)
         * System.out.println("Integer");
         * if(E.getClass() == Double.class)
         * System.out.println("Double");
         * if(E.getClass() == Float.class)
         * System.out.println("Float");
         * if(E.getClass() == Character.class)
         * System.out.println("Character");
         */

    }

    public E pop() {
        E element = null;
        if (!isEmpty()) {
            element = (E) array[0];
            shift();

        }
        return element;
    }

    public boolean isEmpty() {
        return this.array[0] == null;
    }

    public boolean isFull() {
        return this.array[array.length - 1] != null;
    }

    // shift every array item to the previous index sets the last one to null
    // [1,2,3] -> [2,3,null]-> [3,null, null]
    private void shift() {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;

        }
        size--;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}