// Stack Implementation

public class Stack {

    
    Node head;  
    int nodeCount; 
    int size;

    // Node Definition (You decide! You are the programmer)
    public class Node{                         
        //String name = "Node: "; dont know why
        int data;
        Node next;

        Node(int newData , Node nextNode)
        {
            data = newData;     // insert data
            next = nextNode;    // point to the next one
        } // Node constructor
    }

    // Init Stack of size n
    public Stack(int size) {
        head = null;  // empty list is null
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
    // Stack is LIFO
    public void push(int data){
        if(!isFull()) {
            Node newNode = new Node(data, null);
            // if there are no nodes head is now the node
            if (nodeCount == 0) {
                head = newNode;
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
            System.out.println("Could not enter node because the stack is too full");
        }

    }

    // remove a specific key (data) (only one)
    public Node pop(){
        Node curr = head;

        //just make sure there is at least one node
        if(curr != null) {
            //System.out.println("Removing node #" + curr.data);
            head = curr.next;
            nodeCount--;
            
        }
        return curr;
        
    }

    // return the node at the top. 
    public Node peek() { 

        if(head != null && !isEmpty())
            System.out.println("Next node our is node #" + head.data);
 
        return head;
    }

    public void printList() {
        Node curr = head;
        System.out.println("List contains: " + nodeCount+ " nodes");
        System.out.print("[");
        while(curr != null) {

            System.out.print(curr.data);
            curr = curr.next;
            if(curr != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}


