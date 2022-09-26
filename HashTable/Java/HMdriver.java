public class HMdriver {

    public static void main(String[] args) {
        System.out.println("HEllo world");
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 31; i++) {
            map.put(i, (i % 10));
        }
        map.printMap();

        map.put(0, 10);
        map.printMap();
        System.out.println(map.contains(0));
        System.out.println(map.contains(32));

        HashMap<Integer, String> map1 = new HashMap();

        // [1,2,3,4,5,6,7,8,9]
        map1.put(9, "out");
        map1.put(2, "think");
        map1.put(6, "pretty");
        map1.put(1, "I");
        map1.put(3, "I");
        map1.put(8, "figured");
        map1.put(5, "Data Structures");
        map1.put(4, "have");
        map1.put(7, "much");

        for (int i = 0; i < 9; i++) {
            System.out.println(map1.get(i + 1));
        }
        map1.printMap();
        // should throw exception
        map1.get(10);
    }
}