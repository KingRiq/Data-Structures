
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
        if(!isFull()) {
            enter.push(data);
            nodeCount++;
        }
        
    }

    public void leave() {

        //for safety check that both arent empty?
        //ill do this later
        if(!enter.isEmpty() && !leave.isFull()){

        
            //pop everything out of the first stack
            while(!enter.isEmpty()) {
                while(!leave.isFull() && !enter.isEmpty()) {
                    leave.push(enter.pop().data);
                }
            }
        }
        if(!leave.isEmpty()) {
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
        while(!enter.isEmpty()) {
            leave.push(enter.pop().data);
        }
        if (!leave.isEmpty()) {
            peek = leave.peek();
        }
        return peek;
    }

    public void printList() {
        this.peek();
        leave.printList();
    }
}