package ArrayDS;

import java.util.Arrays;

// generic stack queue implementation any type can be used.
public class QueueArray<E> {

    
    private Object array[];
    
    public int size;

    public QueueArray(int size) {
        
        this.array = new Object[size];
        this.size = 0;
    }

    
    public void enqueue(E E) {
        if(!isFull()) {
            array[size] = E;
            if(!isFull()){this.size++;}
        }
        /*
        if(E.getClass() == String.class)
            System.out.println("String");
        if(E.getClass()== Integer.class)
            System.out.println("Integer");
        if(E.getClass() == Double.class)
            System.out.println("Double");
        if(E.getClass() == Float.class)
            System.out.println("Float");
        if(E.getClass() == Character.class)
            System.out.println("Character");
        */
        
    }

    public E dequeue() {
        E element = null;
        if(!isEmpty()) {
            element= (E)array[size];
            array[size] = null;
            size--;
    
        }
        return element;
    }


    public boolean isEmpty() {
        return this.array[0] == null;
    }

    public boolean isFull() {
        return this.array[array.length-1] != null;
    }


    public String toString() {
        return Arrays.toString(array);
    }
}