public class SQdriver {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue(15);
        for(int i =0; i < 10; i++) {
            queue.enter(i);
        }
        System.out.println("---");
        queue.printList();
        System.out.println("---");
        queue.leave();
        queue.leave();
        System.out.println("---");
        queue.printList();
        System.out.println("---");

        for(int i =0; i < 10; i++) {
            queue.enter(i);
        }
        queue.leave();
        queue.leave(); //remove 2 more to check
        System.out.println("---");
        queue.printList();
        System.out.println("---");

    }
}