public class SQdriver {
    public static void main(String[] args) {
        StackQueue queue = new StackQueue(5);
        for(int i =0; i < 2; i++) {
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
    }
}