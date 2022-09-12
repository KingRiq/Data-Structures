// LINKEDLIST OOP
public class LinkedList {

    // Attributes of list
    Node head; // empty list is null (What is a node again?)
    Node tail;
    int nodeCount; // good debugging tool

    // Node Definition (You decide! You are the programmer)
    protected class Node {
        // String name = "Node: "; dont know why
        int data;
        Node next;

        Node(int newData) {
            data = newData;
            // next is null by default
        }

        Node(int newData, Node nextNode) {
            data = newData; // insert data
            next = nextNode; // point to the next one
        } // Node constructor
    }

    // You need initialize LL and node
    public LinkedList() {
        head = null; // empty list is null
        tail = null;
        nodeCount = 0; // good debugging tool
    }

    // Java LL has methods why shouldn't ours
    public void add(int data) {

        // if there are no nodes head is now the node
        head = new Node(data, head);
        if (nodeCount == 0) {
            tail = head;

        }
        nodeCount++;

    }

    // get the value at the current index or return -1 if it doesnt exist or is out
    // of range
    public int get(int index) {

        // we have nodes or the index
        if (nodeCount < 1 || index > nodeCount) {
            return -1;
        }

        Node curr = head;
        // there must be at least one item. Node 1 = index 0 so if there are 2 nodes
        // then index = nodeCount -1

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void addToTail(int data) {
        Node curr = new Node(data, null);
        if (tail == null) {
            tail = curr;
            head = tail;
        } else {
            tail.next = curr;
            tail = tail.next;
        }
        nodeCount++;

    }

    // remove a specific key (data) (only one)
    public void remove(int key) {

        /*
         * User won't know which key is which until printed so we shouldn't either.
         * nodeCount tells us the key exists but thats cheating (maybe)
         * if (nodeCount > key) then we know the key MAY exists but we may have already
         * removed it so we should search every time to be sure
         * it is a time saver at best
         */
        Node curr = head;
        if (curr == head && curr.data == key) {

            // if this is the last Node just reset it.
            // lets create a utility function that will check if we are on the last node or
            // not because I am tired of thinking about it.
            removeFromHead();
            // we found it we need to stop
        } else if (tail.data == key) {
            removeFromTail();
        } else {
            removeFromMiddle(key);
        }

    }

    public void deleteAt(int index) {
        if (index >= nodeCount)
            return;

        if (index == 0) {
            removeFromHead();
        } else if (index == nodeCount - 1) {
            removeFromTail();
        } else {
            Node curr = head;
            // go to the node before the index
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            // another option would be to reuse the remove from middle function
            // this just looks cleaner and we have already traversed the list (so why do it
            // again)
            // removeFromMiddle(curr.next.data); to test

            // comment this out if trying the above comment
            curr.next = curr.next.next;
            nodeCount--;
        }

    }

    public void removeFromHead() {
        if (lastNode()) {
            reset();
        } else {
            head = head.next;
            nodeCount--;
        }
    }

    public void removeFromTail() {

        if (lastNode()) {
            reset();
        } else {
            // not the last node
            Node curr = head;
            while (curr != null && curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
            nodeCount--;
        }
    }

    public void removeFromMiddle(int key) {
        Node curr = head;
        Node prev = curr;
        while (curr != null) { // while the list isnt empty and were not at the end

            // delete anywhere else
            if (curr.data == key) { // normal operation
                curr = curr.next;
                prev.next = curr;
                nodeCount--;
            }
            prev = curr;
            curr = curr.next;

        }
    }

    public void addAt(int data, int index) {
        if (index >= nodeCount)
            return;

        if (index == 0) {
            add(data);

        } else if (index == nodeCount - 1) {
            addToTail(data);

        } else {
            Node curr = head;
            // go to the node before the index
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node node = new Node(data, curr.next.next);
            curr.next = node;
            // another option would be to reuse the remove from middle function
            // this just looks cleaner and we have already traversed the list (so why do it
            // again)
            // removeFromMiddle(curr.next.data); to test

            // comment this out if trying the above comment

            nodeCount++;
            ;
        }

    }

    // if it is the last node we must set head to null and tail to null and set
    // nodeCount to 0
    private boolean lastNode() {
        if (head == tail && nodeCount == 1) {
            return true;
        }
        return false;
    }

    public void reset() {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean isEmpty() {
        if (nodeCount == 0 && head == null && tail == null) {
            return true;
        }
        return false;
    }

    public void printList() {
        Node curr = head;
        System.out.println("List contains: " + nodeCount + " nodes");
        System.out.print("[");
        while (curr != null) {

            System.out.print(curr.data);
            curr = curr.next;
            if (curr != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
