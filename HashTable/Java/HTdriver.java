import java.util.Scanner;

public class HTdriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // hard cord size to 13 for now
        /*HashTable HT = new HashTable(13);
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Saira");
        HT.insert("Table Top");
        HT.insert("Hash Table");
        HT.insert("Secret message");*/
        HashTable1 HT = new HashTable1(13);
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Saira");
        HT.insert("Table Top");
        HT.insert("Hash Table");
        HT.insert("Secret message");


        HT.remove("Eriq");
        HT.printList();
        System.out.println(HT.search("Eriq"));
        System.out.println(HT.search("hire me lol"));
        System.out.println(HT.getSize());
        sc.close();
    }
}