
public class LinkedListTestSuite {
    public static void main(String[] args) {

        testAdd();
        testReset();
        testContains();
        testRemoval();
        testEmpty();
        testGet();
        System.out.println("All Tests Passed");
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

        list.reset();
        assert (list.size() == 0);

        list.add(1);
        list.addToTail(2);
        assert (list.getLast() == 2);
        assert (list.getFirst() == 1);

        // test one node
        list.remove(1);
        assert (list.getFirst() == 2);
        assert (list.getLast() == 2);

        list.reset();
        list.add(2);
        assert (list.getFirst() == 2);
        assert (list.getLast() == 2);

        // test add at index
        list.reset();
        list.addAt(2, 0);
        assert (list.getFirst() == 2);
        assert (list.getLast() == 2);

        // one node
        list.add(1);
        // 1,2

        // list.printList();
        list.addAt(0, 1);
        list.printList();
        // expected 1,0,2
        assert (list.get(1) == 0);

        // size == 3
        // add at 3 (back)
        // 1,0,2,4
        list.addAt(4, 3);
        assert (list.getLast() == 4);
        assert (list.getFirst() == 1);

        // addAt front
        list.addAt(3, 0);
        assert (list.get(0) == 3);
        assert (list.getFirst() == 3);

        // 3,1,0,2,4
        // add 5 at 3
        // 3,1,5,0,2,4
        list.addAt(5, 2);
        list.printList();
        assert (list.get(2) == 5);
        assert (list.get(3) == 0);
        assert (list.get(1) == 1);

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

    public static void testContains() {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
            assert (list.contains(i) == true);
        }

        for (int i = 0; i < 1000; i++) {
            list.remove(i);
            assert (list.contains(i) == false);
        }

        System.out.println("Contains Test successful");
    }

    public static void testRemoval() {
        LinkedList list = new LinkedList();

        // add random int
        list.add(100);
        assert (list.size() == 1);

        // add same int and remove it.
        list.add(100);
        list.remove(100);
        assert (list.size() == 1);
        list.remove(100);
        assert (list.isEmpty() == true);

        // remove from empty list
        list.remove(100);
        assert (list.isEmpty() == true);

        // remove element that does not exist
        list.add(100);
        list.remove(1);
        assert (list.isEmpty() == false);
        assert (list.size() == 1);
        assert (list.contains(100) == true);

        // remove tail
        // tail == 0
        list.reset();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.removeFromTail();
        assert (list.contains(0) == false);
        assert (list.size() == 99);
        list.remove(1);
        list.removeFromTail();
        assert (list.contains(1) == false);
        assert (list.contains(2) == false);
        assert (list.size() == 97);

        // remove from front
        // head == 99
        list.removeFromHead();
        assert (list.contains(99) == false);
        assert (list.size() == 96);

        // head == 98
        // head == 97

        list.remove(98);
        list.removeFromHead();
        assert (list.contains(97) == false);
        assert (list.contains(98) == false);
        list.remove(95);
        list.removeFromHead();
        assert (list.contains(95) == false);
        assert (list.contains(96) == false);

        // test removal from middle
        list.remove(50);
        assert (list.contains(50) == false);

        // delete at index
        list.reset();
        assert (list.size() == 0);

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        // 4,3,2,1,0
        // remove 1
        list.deleteAt(3);
        assert (list.contains(1) == false);

        // front = 4
        // 4,3,2,0
        list.deleteAt(0);
        assert (list.contains(4) == false);

        // back == 0
        // 3,2,0
        list.deleteAt(2);
        assert (list.contains(0) == false);
        assert (list.size() == 2);

        // delete out of range
        // 3,2

        list.deleteAt(3);
        list.deleteAt(-1);
        list.deleteAt(50);
        list.deleteAt(2);
        assert (list.size() == 2);

        list.deleteAt(1);
        assert (list.contains(2) == false);
        assert (list.size() == 1);

        // test tail and head removal of single node
        list.removeFromHead();
        assert (list.isEmpty() == true);
        list.add(3);
        list.removeFromTail();
        assert (list.isEmpty() == true);
        list.add(3);
        list.remove(3);
        assert (list.isEmpty() == true);
        assert (list.size() == 0);

        // test multiple adds and removals
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
            list.remove(i);
            assert (list.contains(i) == false);
            assert (list.isEmpty() == true);
            assert (list.size() == 0);
        }

        assert (list.isEmpty() == true);
        assert (list.size() == 0);

        // test removal of head && tail extreme
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // removal from tail is expensive! O(n) for each n removal is head is O(1)
        for (int i = 0; i < (1000 / 2); i++) {
            list.removeFromHead();
            list.removeFromTail();

        }
        assert (list.size() == 0);

        System.out.println("Removal Test Complete");

    }

    public static void testEmpty() {
        LinkedList list = new LinkedList();

        assert (list.isEmpty() == true);
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
            assert (list.isEmpty() == false);
        }

        for (int i = 0; i < 1000000; i++) {
            assert (list.isEmpty() == false);
            list.removeFromHead();
        }

        assert (list.isEmpty() == true);
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
            assert (list.isEmpty() == false);
        }
        list.reset();
        assert (list.isEmpty() == true);

        System.out.println("Empty Test Complete");
    }

    public static void testGet() {
        LinkedList list = new LinkedList();

        // out of range
        assert (list.get(0) == -1);
        assert (list.get(1) == -1);
        assert (list.get(-1) == -1);

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assert (list.get(0) == 99);
        assert (list.get(100) == -1);
        assert (list.get(99) == 0);
        assert (list.get(-1) == -1);

        System.out.println("Get Test Complete");

    }
}