

public class BTdriver {
    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();

        BT.insert(1);
        BT.insert(1);
        BT.insert(1);
        BT.insert(1);
        BT.insert(3);
        BT.insert(5);
        BT.insert(2);
        BT.insert(8);

        while ((int) (Math.random()*1000) != 0) {
            BT.insert((int) (Math.random()*1000));
        }

       
        BT.print_Ordered();
    }
}