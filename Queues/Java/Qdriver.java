import java.util.Scanner;

//Driver for LL
public class Qdriver {
public static void main(String[] args ) {
    Scanner sc = new Scanner(System.in);
    

    System.out.println("How many nodes do you want?");
    
    String input = sc.next();
    int number = Integer.parseInt(input);
    Queue queue = new Queue(number);
    for(int i = 0; i<number+2; i++) {
        queue.enter(i);
    }

    
    queue.printList();
    
    boolean quit = false;
    while(!quit && !queue.isEmpty()) {
        
        System.out.println("Emptying List press q to quit");
        input = sc.nextLine();
        if(input.equals("q")) {
            quit = true;
        }
        else{
            queue.leave();
        }

    }

    sc.close();
    System.out.println("Process Complete");
}

}