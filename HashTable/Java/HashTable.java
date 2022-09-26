//HashTable

// using a node array. I prefer this way.
// after observation this is technically a hashset... where 
// ill use 31 as my hash (10x+y) %31 for example
public class HashSet {

    private Node[] HashArray;
    int entryNum;
    final static int hash = 31;

    public class Node {
        String key;
        int nodeCount;
        Node next;

        public Node(String key, Node newNode) {
            this.key = key;
            next = newNode;
        }
    }

    public HashSet(int size) {
        HashArray = new Node[size];
        entryNum = 0;

        for (int i = 0; i < HashArray.length; i++) {
            HashArray[i] = null;
        }
    }

    protected void insertNode(int hashIndex, String key) {
        // Create a new node
        Node newNode = new Node(key, null);

        // check if initialized
        if (HashArray[hashIndex] == null)
            HashArray[hashIndex] = newNode;
        else {
            newNode.next = HashArray[hashIndex];
            HashArray[hashIndex] = newNode;
        }
        entryNum++;

    }

    private int hash(String key) {

        int hashIndex = 0;
        for (int i = 0; i < key.length(); i++) {
            hashIndex = ((hashIndex * hash) + key.charAt(i)) % HashArray.length;
        }
        return hashIndex;
    }

    public void insert(String key) {

        // get the hash of the string in question
        int hashIndex = hash(key);

        // if the key does not exist already do stuff
        if (!contains(key)) {

            // we didnt find it so enter it.
            insertNode(hashIndex, key);
        }

    }

    public boolean contains(String key) {
        boolean found = false;
        int hashIndex = hash(key);
        Node curr = HashArray[hashIndex];

        while (curr != null && !found) {
            found = curr.key.equals(key);
            curr = curr.next;
        }

        return found;
    }

    public void printList() {
        for (int i = 0; i < HashArray.length; i++) {
            Node curr = HashArray[i];
            System.out.print("Bucket[" + i + "]: ");
            while (curr != null) {
                System.out.print(curr.key);

                if (curr.next != null) {
                    System.out.print(", ");
                }
                curr = curr.next;
            }

            System.out.println();

        }

    }
}