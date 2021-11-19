
/* Something cool that Prof Cuneyt Akcora
* taught us in algorithms was that
* you can implement a queue using two stacks
* this has stuck with me so I will implement it
* again for fun
*/

public class StackQueue {
    Stack enter;
    Stack leave;
    int size; 
    int nodeCount;

    public StackQueue(int size) {
        enter = new Stack(size);
        leave = new Stack(size);
        this.size = size;
        nodeCount = 0;
    }

    // Stacks are LIFO so you pop everything into a different stack
    // Your Last node is now your first and the first is now the last

    public void enter(int data) {
        queue_nodes();
        if(!isFull()) {
            enter.push(data);
            nodeCount++;
        }
        
    }

    public void leave() {

        //for safety check that both arent empty?
        //ill do this later
        load_nodes();
        if(!leave.isEmpty()) { // leave has to be empty before putting
            leave.pop();
            nodeCount--;
        } 

        
    }

    public boolean isFull() {
        boolean full = false;
        if(nodeCount >= size) { //should never be greater
            full = true;

            System.out.println("Queue is full");
        }
        return full;
    }

    public boolean isEmpty() {
        boolean empty = false;
        if(nodeCount == 0) {
            empty = true;

            System.out.println("Queue is empty");
        }
        return empty;
    }

    public Stack.Node peek() {
        Stack.Node peek = null;
        
        queue_nodes();
        if (!leave.isEmpty()) {
            peek = leave.peek();
        }
        
        return peek;
    }

    public void printList() {
        queue_nodes();
        load_nodes();
        leave.printList();
    }

    void queue_nodes() { //needed to make sure enter does not pop unless leave is empty
            while(!leave.isEmpty() && !enter.isFull())
                enter.push(leave.pop().data);

    }       
    

    void load_nodes() { // make sure leave stack is loaded properly
        while(!leave.isFull() && !enter.isEmpty()) {
            leave.push(enter.pop().data);
        }
    }
}