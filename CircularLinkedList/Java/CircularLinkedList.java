// LINKEDLIST OOP
public class CircularLinkedList {

    //Attributes of list
    Node head;  // empty list is null 
    Node last;  //technically cheating? Idk you may not need this... its just easier

    int nodeCount; //good debugging tool

    // Node Definition (You decide! You are the programmer)
    protected class Node{                         
        //String name = "Node: "; dont know why
        int data;
        Node next;

        Node(int newData , Node nextNode)
        {
            data = newData;     // insert data
            next = nextNode;    // point to the next one
        } // Node constructor
    }

    // You need initialize LL and node
    public CircularLinkedList() {
        head = null;  // empty list is null
        last = null;
        nodeCount = 0; //good debugging tool
    }

    // Java LL has methods why shouldn't ours
    public void add(int data){
        Node newNode = new Node(data, null);
        // if there are no nodes head is now the node
        if (nodeCount == 0) {
            head = newNode; //head points to itself NOTICE: last still = head
            nodeCount++;
        }
        else {
            //add it in front
            last.next = newNode; //circular
            nodeCount++;
        }
        last = newNode;
        last.nextNode = head;
    }

    // remove a specific key (data) (only one)
    // its tricky because you have to keep track of where the head is or you will break the circular link.
    public void remove(int key){
        Node curr = head;
        Node prev = curr;

        /* User won't know which key is which until printed so we shouldn't either. nodeCount tells us the key exists but thats cheating (maybe)
         * if (nodeCount > key) then we know the key MAY exists but we may have already removed it so we should search every time to be sure
         * it is a time saver at best */

         while(head != null && curr != null) { // while the list isnt empty and were not at the end

            //if head is the only node we just remove it and set everything to null
            if(head.data == key && head.next == head)
            {
                head =null;
                last = head;
                curr = head;
                nodeCount--;
                break;
            }

            //if the first element just increment head and java will collect the trash... nothing references it anymore
            if(curr == head && curr.data == key) {
                 head = curr.next;      //move head down one
                 curr = head;           
                 last.next = head;     // you would have to traverse the list and use prev otherwise
                 nodeCount--;
                 break; //we found it we need to stop
            }
           
            // we only care if we are changing the head node... everything else is by definition a normal operation
            if(curr.data == key) { // normal operation
                curr = curr.next;
                prev.next = curr;
                nodeCount--;
                
                
            }
            prev = curr;
            curr = curr.next;

            //check if the cycle is done
            if(curr == head) {
                last = prev; // not needed
                last.next = head; //stay circular
                curr = null;
            }
            
            // its important to note again... last is not needed. prev will be the "last" when curr
         }
    }

    public void printList() {
        Node curr = head;
        if(nodeCount > 0) {
            System.out.println("List contains: " + nodeCount+ " nodes");
            System.out.print("[");
            
            while(curr != null) {

                System.out.print(curr.data);
                curr = curr.next;
                if(curr != head ){
                System.out.print(",");
            }
            
            // comment out else to see circular nature (there are no nodes with null)
            else {
                curr = null;
            }

        }
        System.out.println("]");
        
        
    }
    else {
        System.out.println("Empty list");
    }
    }
}


