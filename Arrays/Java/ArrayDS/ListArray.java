package ArrayDS;

import java.lang.reflect.Array;
import java.util.Arrays;

// quick implementation of Arraylist because boredom
public class ListArray<T> implements ArrayDSInterface {
    // An arraylist is just an array right?
    private Object array[];
    private int size;

    public ListArray(int size) {

        this.array = new Object[size];
        this.size = 0;
    }

    // documentation states this returns a boolean or throws an error (I didnt look
    // at it but this is what I interpret it as)
    public boolean add(T element) {
        if (!isFull()) {
            array[size] = element;
            size++;
            return true;
        } else {
            resize(size);
            return add(element);
        }
        // should never happen but...
        // return false; //unreachable code error
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        insert(index);
        if (size == array.length) {
            resize(size);
        }
        array[index] = value;
        size++;
    }

    private void insert(int index) {
        // copy from end to index where index is always less than the size and size is
        // always less than the length
        // upon insertion (study the code above to understand why)
        for (int i = size() - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
    }

    // public T dequeue() {
    // T element = null;

    // if (!isEmpty()) {
    // element = (T) array[size - 1];
    // array[size - 1] = null;
    // size--;

    // }

    // return element;
    // }

    public boolean isEmpty() {

        return this.array[0] == null;
    }

    // I will use this cleverly
    public boolean isFull() {
        return this.array[array.length - 1] != null;
    }

    public String toString() {
        String string = "";
        string += "[";
        for (int i = 0; i < size(); i++) {
            string += array[i].toString();
            if (i != size() - 1) {
                string += ", ";
            }
        }
        string += "]";
        // technically wrong by documentation
        // return Arrays.toString(array);
        return string;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            // out of range
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void resize(int size) {
        Object newArray[] = new Object[size * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void clear() {
        array = new Object[1];
        size = 0;
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        T temp = (T) array[index];
        array[index] = value;
        return temp;
    }

    public Object[] toArray() {
        int length = 0;

        while (array[length] != null) {
            length++;
        }
        Object newArray[] = new Object[length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // at this point I'm just implementing documentation but whatever
    public <T> T[] toArray(T[] array) {
        // create one big enough
        if (array.length < size) {

            // create a instance of array of type (whatever this class is at run time)
            // we cannot determine this at compile time and thats the reason Ive programmed
            // all of this
            // in the first place
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), size());

        } // else array is big enough

        for (int i = 0; i < size(); i++) {
            array[i] = (T) this.array[i];
        }
        for (int i = size(); i < array.length; i++) {
            array[i] = null;
        }
        return array;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        T temp = (T) array[index];
        shift(index);
        // our size just shrank so the item we insert will overwrite this position
        array[size] = null;
        return temp;

    }

    private void shift(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        size--;
    }

}
