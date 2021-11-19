// Queue
public class MyQueue {

    
    Node head;
    Node last;  
    int nodeCount; 
    int size;

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

    // Init Queue of size n
    public MyQueue(int size) {
        head = null;  // empty list is null
        last = null;
        nodeCount = 0; //good debugging tool
        this.size = size;
    }

    public boolean isFull() {
        boolean full = false;
        if(nodeCount == size) {
            full = true;
        }
        return full;

    }

    public boolean isEmpty() {
        boolean empty = false;
        if(nodeCount == 0) {
            empty = true;
        }
        return empty;
    }
    // Queue is FIFO
    public void enter(int data){
        if(!isFull()) {
            Node newNode = new Node(data, null);
            // if there are no nodes head is now the node
            if (nodeCount == 0) {
                head = newNode;
                last = head;
                nodeCount++;
            }
            else {
                //add it in front
                newNode.next = head;
                head = newNode; //head is the newest node
                nodeCount++;
            }
        }
        else {
            System.out.println("Could not enter node because the queue is too full");
        }

    }

    // remove a specific key (data) (only one)
    public void leave(){
        Node curr = head;

        while(!isEmpty() && curr != null) {
            
            // check for only one node
            if(curr.next == null) {
                head = null;
                last = null;
                curr = null;
                nodeCount--;
                break;
            }

            //stop right before the last node
            if(curr.next == last) {
                last = curr;
                last.next = null;
                curr = null;
                nodeCount--;
                break;
            }
            curr = curr.next;    
        }
        printList();
    }

    // return the node at the top. 
    public int peek() { 
        if(!isEmpty()) {
            return last.data;
        }
        return  -1;
    }

    public void printList() {
        Node curr = head;
        System.out.println("List contains: " + nodeCount+ " nodes");
        System.out.print("[");
        while(curr != null) {

            System.out.print(curr.data);
            curr = curr.next;
            if(curr != null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {

        return nodeCount;
    } 
}


