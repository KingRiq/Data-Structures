import java.util.Scanner;

public class HTdriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // this data structure is more of a hashset now that I think about it.
        // I hope to make a hashmap implementation soon (TODAY IS THE DAY BABY SEPT 26
        // 2022)

        // hard cord size to 13 for now
        /*
         * HashTable HT = new HashTable(13);
         * HT.insert("Eriq");
         * HT.insert("Eriq");
         * HT.insert("Eriq");
         * HT.insert("Eriq");
         * HT.insert("Saira");
         * HT.insert("Table Top");
         * HT.insert("Hash Table");
         * HT.insert("Secret message");
         */
        HashSet1 HT = new HashSet1(3);
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Eriq");
        HT.insert("Saira");
        HT.insert("Table Top");
        HT.insert("Hash Table");
        HT.insert("Secret message");
        System.out.println(HT.contains("Eriq")); // true
        HT.insert("hire me lol");
        System.out.println(HT.contains("hire me lol")); // true
        HT.printList();
        HT.remove("Eriq");
        HT.remove("hire me lol");
        HT.printList();
        System.out.println(HT.contains("Eriq")); // false
        System.out.println(HT.contains("hire me lol")); // false
        System.out.println(HT.getSize());
        sc.close();
        // HT = new HashTable1(7);
        // for (int i = 0; i < 50; i++) {
        // HT.insert(randomString());
        // }

        // HT.printList();
        // System.out.println(HT.getSize());

    }

    // taken from tutorials point for testing!
    public static String randomString() {
        int string_size = 10;
        // System.out.println("The size of the string is defined as: " + string_size);
        String alpha_numeric = "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(string_size);
        for (int i = 0; i < string_size; i++) {
            int index = (int) (alpha_numeric.length() * Math.random());
            sb.append(alpha_numeric.charAt(index));
        }

        String result = sb.toString();
        return result;
    }

}