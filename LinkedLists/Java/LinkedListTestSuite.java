
public class LinkedListTestSuite {
    public static void main(String[] args) {

        testAdd();
        testReset();
    }

    // test regular add
    public static void testAdd() {

        LinkedList list = new LinkedList();

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        assert (list.size() == 10);

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        assert (list.size() == 20);

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        assert (list.size() == 30);

        list.printList();

        System.out.println("Add Test Successful");
    }

    public static void testReset() {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        assert (!list.isEmpty());
        list.reset();

        assert (list.size() == 0);
        assert (list.isEmpty());

        System.out.println("Reset Test Successful");

    }
}