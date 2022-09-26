import java.util.Arrays;
import java.util.NoSuchElementException;

public class HashMap<E, R> {

    private Node[] HashArray; // buckets
    int entryNum; // size
    final static int hash = 31;

    // Create Node Class
    public class Node<E, R> {

        // every node will have the key and the data
        E key;
        R data;
        Node next;

        public Node(E key, R data, Node next) {
            this.key = key;
            this.data = data;
            this.next = next;

        }

    }

    public HashMap() {
        HashArray = new Node[hash];
        entryNum = 0;

        // refer to hashset I have already implemented this as practice
        Arrays.fill(HashArray, null);
    }

    // need hash function to figure out where this bucket will be
    private int hash(E key) {

        int hashIndex = 0;
        hashIndex = key.hashCode() % hash;
        return hashIndex;
    }

    // we need to the NODE insert into that bucket
    private void insertNode(int hashIndex, E key, R data) {
        Node newNode = new Node(key, data, null);

        // check if initialized (need to check for duplicates at some point too)
        if (HashArray[hashIndex] == null)
            HashArray[hashIndex] = newNode;
        else {
            newNode.next = HashArray[hashIndex];
            HashArray[hashIndex] = newNode;
        }
        entryNum++;

    }

    // will always overwrite value
    public void put(E key, R data) {
        int hashIndex = hash(key);

        // insert this (but only if it does not contain it)
        if (!contains(key)) {
            insertNode(hashIndex, key, data);

        } else {
            Node curr = HashArray[hashIndex];
            while (curr != null) {
                if (curr.key == key) {
                    curr.data = data;
                    break;
                }
                curr = curr.next;
            }
        }
    }

    public R get(E key) {

        if (contains(key)) {
            int hashIndex = hash(key);
            Node curr = HashArray[hashIndex];
            while (curr != null) {
                if (curr.key == key) {
                    return (R) curr.data;
                }
                curr = curr.next;
            }
        } else {
            throw new NoSuchElementException("This Element Does not exist");
        }
        // should never run
        return null;
    }

    public R getOrDefault(E key, R value) {
        if (contains(key)) {
            return get(key);
        } else {
            put(key, value);
            return get(key);
        }
    }

    // O(1) look up because
    public boolean contains(E key) {
        int hashIndex = hash(key);
        Node curr = HashArray[hashIndex];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void printMap() {
        System.out.println("Printing Map");
        System.out.print("[");
        for (int i = 0; i < HashArray.length; i++) {

            // if you care to know which bucket an item is in
            // System.out.print("Bucket " + (i + 1) + ":{");
            Node curr = HashArray[i];
            while (curr != null) {
                System.out.print("(" + curr.key + ", " + curr.data + ")");
                if (curr.next != null) {
                    System.out.print(", ");
                }
                curr = curr.next;
            }
            System.out.print("} ");
        }
        System.out.println("]");
    }

    // next I need to make this DS iterable. Ill think about this on my free time...
    // EX: Maybe loop through FOR every entry find the highest value

}