// Inteferace for Linked Lists

public interface List {

    public void add(int data);

    // get the value at the current index or return -1 if it doesnt exist or is out
    // of range
    public int get(int index);

    public void addToTail(int data);

    // remove a specific key (data) (only one)
    public void remove(int key);

    // delete at a specific index
    public void deleteAt(int index);

    // remove first item
    public void removeFromHead();

    // remove last item
    public void removeFromTail();

    // add at a specific index. Current data takes it place and shifts previous data
    // to the next index
    public void addAt(int data, int index);

    // resets list to empty
    public void reset();

    // returns size
    public int size();

    // returns true if the list is empty
    public boolean isEmpty();

    // checks if an int exists in the list
    public boolean contains(int key);

    // gets tail value or returns -1
    public int getLast();

    // gets head or returns -1
    public int getFirst();

    // prints the list (typical debugging tool but also useful)
    public void printList();
}
