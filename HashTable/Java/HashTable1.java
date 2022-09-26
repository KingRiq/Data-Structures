//HashTable
// using my LL implentation.
// ill use 31 as my hash (10x+y) %31 for example
public class HashSet1 {

    private LinkedList[] HashArray;
    int entryNum; // size
    final static int hash = 31;

    public HashSet1(int size) {
        HashArray = new LinkedList[size];
        entryNum = 0;

        for (int i = 0; i < HashArray.length; i++) {
            HashArray[i] = null;
        }
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
            if (HashArray[hashIndex] == null) {
                HashArray[hashIndex] = new LinkedList();
            }
            // we didnt find it so enter it.
            HashArray[hashIndex].add(key);
        }
    }

    public void remove(String key) {
        int hashIndex = hash(key);
        if (HashArray[hashIndex] != null) {
            HashArray[hashIndex].remove(key);
        }
    }

    public boolean contains(String key) {
        int hashIndex = hash(key);
        boolean found = false;
        if (HashArray[hashIndex] != null) {
            found = HashArray[hashIndex].contains(key);
        }
        return found;
    }

    public void printList() {
        for (int i = 0; i < HashArray.length; i++) {

            System.out.print("Bucket[" + i + "]: ");
            if (HashArray[i] != null)
                HashArray[i].printList();

            System.out.println();

        }
    }

    public void reset() {
        for (int i = 0; i < HashArray.length; i++) {
            HashArray[i] = null;
        }
    }

    public int getSize() {
        entryNum = 0;
        for (int i = 0; i < HashArray.length; i++) {
            if (HashArray[i] != null) {
                entryNum += HashArray[i].size();
            }
        }
        return entryNum;
    }
}