// LINKEDLIST OOP
public class LinkedList {

    //Attributes of list
    Node head;  // empty list is null (What is a node again?)
    int nodeCount; //good debugging tool

    // Node Definition (You decide! You are the programmer)
    public class Node{                         
        //String name = "Node: "; dont know why
        String key;
        Node next;

        Node(String key, Node nextNode)
        {
            this.key = key;
            next = nextNode;    // point to the next one
        } // Node constructor
    }

    // You need initialize LL and node
    public LinkedList() {
        head = null;  // empty list is null
        nodeCount = 0; //good debugging tool
    }

    // Java LL has methods why shouldn't ours
    public void add(String key){
        
        // if there are no nodes head is now the node
        if (nodeCount == 0) {
            head = new Node(key, null);
            nodeCount++;
        }
        else {
            //add it in front
            Node newNode = new Node(key, head);
            head = newNode; //head is the newest node
            nodeCount++;
        }

    }

    // remove a specific key (data) (only one)
    public void remove(String key){
        Node curr = head;
        Node prev = curr;

        /* User won't know which key is which until printed so we shouldn't either. nodeCount tells us the key exists but thats cheating (maybe)
         * if (nodeCount > key) then we know the key MAY exists but we may have already removed it so we should search every time to be sure
         * it is a time saver at best */

         while(head != null && curr != null) { // while the list isnt empty and were not at the end

            //if the first element just increment head and java will collect the trash... nothing references it anymore
            if(curr == head && curr.key == key) {
                 head = curr.next;
                 curr = head;
                 prev = curr;
                 nodeCount--;
                 break; //we found it we need to stop
            }
            if(curr.next == null && curr.key == key) { //we hit the last one just get rid of it.
                prev.next = null;
                curr = prev;
                nodeCount--;
            }//do we need this?
            if(curr.key == key) { // normal operation
                curr = curr.next;
                prev.next = curr;
                nodeCount--;
            }
            prev = curr;
            curr = curr.next;

         }
    }
    public boolean search(String key) {
        Node curr = head;
        boolean found = false;
        while(curr != null && !found) {
            found = curr.key.equals(key);
            curr = curr.next;
        }

        return found;
    }
    public void printList() {
        Node curr = head;
        System.out.println("List contains: " + nodeCount+ " nodes");
        System.out.print("[");
        while(curr != null) {

            System.out.print(curr.key);
            curr = curr.next;
            if(curr != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    
    public int size() {
        return nodeCount;
    }
}


