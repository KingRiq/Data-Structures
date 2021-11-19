import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Driver for Queue to show how my queue functions versus the standard library
public class Qdriver {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
    
        // dynamically add nodes from user input (fix edge case for 0 later)
        System.out.println("How many nodes do you want?");
        String input = sc.nextLine();
        int number = Integer.parseInt(input);
    
        //initialization
        MyQueue queue = new MyQueue(number);
        Queue<Integer> queue1 = new LinkedList<Integer>();

        // Add nodes in succession and don't exceed the specified size
        // Go past the specified size to prove no insertion occurs
        for(int i = 0; i<number+2; i++) {
            queue.enter(i);
            System.out.println(queue.size());
            
            // don't continue to insert in standard queue
            if(i < queue.size()) { 
            queue1.add(i);
            }
        }

        // logs after insertion
        System.out.println("Let's print out some stats first");
        System.out.println("The next number in queue is " + queue.peek());
        System.out.println("Queue full =  "+ queue.isFull());
        System.out.println("Queue empty = "+ queue.isEmpty());
        queue.printList();
        System.out.println(queue1);
        System.out.println("----------------------------------------------");

        // remove from list one by one until the user is tired of doing so
        boolean quit = false;
        while(!quit && !queue.isEmpty()) {
        
            System.out.println("Emptying List press q to quit");
            input = sc.nextLine();
            if(input.equals("q")) {
                quit = true;
            }
            else {
                queue.leave();
                queue1.remove();
                // prints standard queue from last to head (mine prints from head to last) so it will print backward.
                System.out.println(queue1);
                
                // let the user know what node is next for removal
                if(queue1.peek() != null)
                    System.out.println(queue1.peek()+ " is the next node for deletion");
            }
        }

        // log check is full, empty
        System.out.println("Queue full =  "+ queue.isFull());
        System.out.println("Queue empty = "+ queue.isEmpty() + "\n");
        sc.close();

        // test assert
        //queue1.add(1);

        // uncomment line 64 run with java -ea to test 
        assert(queue1.size() == 0 && queue.size() == 0);

        System.out.println("Process Complete");
    }

}
