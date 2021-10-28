import java.util.Scanner;



//Driver for Queue
public class Qdriver {
public static void main(String[] args ) {
    Scanner sc = new Scanner(System.in);
    

    System.out.println("How many nodes do you want?");
    
    String input = sc.nextLine();
    int number = Integer.parseInt(input);
    Queue queue = new Queue(number);
    
    for(int i = 0; i<number+2; i++) {
        queue.enter(i);
    }

    queue.peek();
    System.out.println("Queue full =  "+ queue.isFull());
    System.out.println("Queue empty = "+ queue.isEmpty());
    queue.printList();
    boolean quit = false;
    while(!quit && !queue.isEmpty()) {
        
        System.out.println("Emptying List press q to quit");
        input = sc.nextLine();
        if(input.equals("q")) {
            quit = true;
        }
        else {
            queue.leave();
        }

    }

    //log
    queue.peek();
    System.out.println("Queue full =  "+ queue.isFull());
    System.out.println("Queue empty = "+ queue.isEmpty());

    sc.close();
    System.out.println("Process Complete");
}

}