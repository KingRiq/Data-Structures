import java.util.Scanner;

//Driver for LL
public class CLLdriver {
    public static void main(String[] args ) {
        //neeed variables
        Scanner sc = new Scanner(System.in);
        String input;
        int number;
        CircularLinkedList list = new CircularLinkedList();
        System.out.println("First let's prove its circular");
        list.add(700);
        list.add(1);
        list.printList1();
        list.reset();

        System.out.println("Ok, test done. Your turn!");
        
        addNodes(list,sc);

        

    
        list.printList();
        boolean quit = false;
        while(!quit && list.size() >0) {
        
            System.out.println("Which nodes do you want to remove? press q to quit or 'r' to reset");
            input = parseResponse(sc);
            if(input.equals("q")) {
                quit = true;
            }
            else if(input.equals("r")) {
                list.reset();
                addMorePrompt(list, sc);
            }
            else {
                number = Integer.parseInt(input);
                list.remove(number);
                if(list.size() == 0)
                {
                    addMorePrompt(list,sc);
                }
            }
            list.printList();
        }
        sc.close();
        System.out.println("Process Complete");
    }

    public static void addNodes( CircularLinkedList list, Scanner sc) {
        System.out.println("How many nodes do you want?");
        String input = parseResponse(sc);
        int number = Integer.parseInt(input);

        for(int i = 0; i<number; i++) {
            list.add(i);
        }
    }

    public static void addMorePrompt(CircularLinkedList list, Scanner sc) {
        
        System.out.println("Would you like to add more nodes? Press 'y' for yes 'n' for no");
        String input = parseResponse(sc);
        if(input.equals("y"))
            addNodes(list, sc);
        // else do nothing for now
        
    }

    public static String parseResponse(Scanner sc) {
        
        String input = sc.next();
        
        return input;
    }
}