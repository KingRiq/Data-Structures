import java.util.Scanner;



//Driver for LL
public class Stackdriver {
public static void main(String[] args ) {
    Scanner sc = new Scanner(System.in);
    

    System.out.println("How many nodes do you want?");
    
    String input = sc.next();
    int number = Integer.parseInt(input);
    Stack stack = new Stack(number);
    
    for(int i = 0; i<number+2; i++) {
        stack.push(i);
    }

    stack.peek();
    System.out.println("Stack full =  "+ stack.isFull());
    System.out.println("Stack empty = "+ stack.isEmpty());
    stack.printList();
    boolean quit = false;
    while(!quit && !stack.isEmpty()) {
        
        System.out.println("Emptying List press q to quit");
        input = sc.nextLine();
        if(input.equals("q")) {
            quit = true;
        }
        else {
            stack.pop();
        }

    }

    //log
    stack.peek();
    System.out.println("Stack full =  "+ stack.isFull());
    System.out.println("Stack empty = "+ stack.isEmpty());
    sc.close();
    System.out.println("Process Complete");
}

}