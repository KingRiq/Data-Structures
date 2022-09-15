public class DoublyLinkedList implements List {
    Node head;
    Node tail;
    int nodeCount;

    protected class Node {
        int data;
        Node next;
        Node prev;

        // lets define the head's prev pointer to be null!
        Node(int data) {
            this.data = data;
        }

        // probably head insertion
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // probably used to insert at index
        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    public DoublyLinkedList() {
        head = null; // empty list is null
        tail = null;
        nodeCount = 0; // good debugging tool
    }

    public void add(int data) {

        // if there are no nodes head is now the node
        Node newNode = new Node(data);
        if (nodeCount == 0 && head == null && tail == null) {
            head = newNode;
            tail = head;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        nodeCount++;

    }

    public int get(int index) {

        // we don't have nodes or the index is out of range
        if (nodeCount < 1 || index >= nodeCount || index < 0) {
            return -1;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void addToTail(int data) {
        Node curr = new Node(data, null);
        if (tail == null) {
            curr.prev = null;
            tail = curr;
            head = tail;
        } else {
            tail.next = curr;
            curr.prev = tail;
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

        // if the list is empty there is nothing to remove
        Node curr = head;
        if (!isEmpty()) {
            if (curr != null && curr == head && curr.data == key) {

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

    }

    // remove first item
    public void removeFromHead() {

        if (!isEmpty()) {
            if (lastNode()) {
                reset();
            } else {
                head = head.next;
                head.prev = null;
                nodeCount--;
            }
        }
    }

    // remove last item
    public void removeFromTail() {
        if (!isEmpty()) {
            if (lastNode()) {
                reset();
            } else {
                // not the last node
                tail = tail.prev;
                tail.next = null;
                nodeCount--;
            }
        }
    }

    public void removeFromMiddle(int key) {
        Node curr = head;
        while (curr != null) { // while the list isnt empty and were not at the end

            // go to the node at index
            if (curr.data == key) {
                // prev node must connect to next
                // next must connect to prev
                // curr will be collected by garbage collector
                Node prev = curr.prev;
                Node next = curr.next;
                prev.next = next;
                next.prev = prev;
                nodeCount--;
            }
            curr = curr.next;
        }

    }

    // delete at a specific index
    public void deleteAt(int index) {
        if (index >= nodeCount || index < 0)
            return;

        if (!isEmpty()) {
            if (index == 0) {
                removeFromHead();
            } else if (index == nodeCount - 1) {
                removeFromTail();
            } else {
                Node curr = head;
                // go to the node at index
                for (int i = 0; i < index; i++) {
                    curr = curr.next;
                }

                // prev node must connect to next
                // next must connect to prev
                // curr will be collected by garbage collector
                Node prev = curr.prev;
                Node next = curr.next;
                prev.next = next;
                next.prev = prev;
                nodeCount--;
            }
        }

    }

    // add at a specific index. Current data takes it place and shifts previous data
    // to the next index
    public void addAt(int data, int index) {
        if (index > nodeCount)
            return;

        if (index == 0) {
            add(data);

        } else if (index == nodeCount) {
            addToTail(data);

        } else {
            Node curr = head;
            // go to the node index
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            // save prev
            Node prev = curr.prev;
            Node node = new Node(data, curr);
            prev.next = node;
            node.prev = prev;
            // another option would be to reuse the remove from middle function
            // this just looks cleaner and we have already traversed the list (so why do it
            // again)
            // removeFromMiddle(curr.next.data); to test

            // comment this out if trying the above comment

            nodeCount++;

        }

    }

    // resets list to empty
    public void reset() {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    // returns size
    public int size() {
        return nodeCount;
    }

    // checks if an int exists in the list
    public boolean contains(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // gets tail value or returns -1
    public int getLast() {

        if (tail != null) {
            return tail.data;
        }
        return -1;
    }

    // gets head or returns -1
    public int getFirst() {
        if (head != null) {
            return head.data;
        }
        return -1;
    }

    // if it is the last node we must set head to null and tail to null and set
    // nodeCount to 0
    private boolean lastNode() {
        if (head == tail && nodeCount == 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (nodeCount == 0 && head == null && tail == null) {
            return true;
        }
        return false;
    }

    // prints the list (typical debugging tool but also useful)
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

    public void printListReverse() {
        Node curr = tail;
        System.out.println("List contains: " + nodeCount + " nodes");
        System.out.print("[");
        while (curr != null) {

            System.out.print(curr.data);
            curr = curr.prev;
            if (curr != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}