import java.util.Scanner;

//Driver for LL
public class CLLdriver {
public static void main(String[] args ) {
    Scanner sc = new Scanner(System.in);
    CircularLinkedList list = new CircularLinkedList();

    System.out.println("How many nodes do you want?");
    String input = sc.next();
    int number = Integer.parseInt(input);

    for(int i = 0; i<number; i++) {
        list.add(i);
    }

    
    list.printList();
    boolean quit = false;
    while(!quit) {
        
        System.out.println("Which nodes do you want to remove? press q to quit");
        input = sc.next();
        if(input.equals("q")) {
            quit = true;
        }
        else{
            number = Integer.parseInt(input);
            list.remove(number);
        }
        list.printList();

    }

    sc.close();
    System.out.println("Process Complete");
}

}