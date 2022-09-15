import java.util.Scanner;

//Driver for LL
public class LLdriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("How many nodes do you want?");
        String input = sc.next();
        int number = Integer.parseInt(input);
        int size = number;

        for (int i = 0; i < number; i++) {
            list.add(i);
        }

        list.printList();
        boolean quit = false;
        while (!quit) {

            System.out.println("Which nodes do you want to remove? press q to quit");
            input = sc.next();
            if (input.equals("q")) {
                quit = true;
            } else {
                number = Integer.parseInt(input);
                list.remove(number);
            }
            list.printList();
        }

        sc.close();

        DoublyLinkedList list1 = new DoublyLinkedList();
        for (int i = 0; i < size; i++) {
            list1.add(i);
        }

        list1.printList();
        list1.printListReverse();
        System.out.println("Process Complete");
    }

}