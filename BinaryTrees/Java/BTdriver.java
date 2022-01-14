

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

        // I never once tried to delete anything... how thats very unlike me.
        // anyways...

        //Start over and be thorough

        BinaryTree BT1 = new BinaryTree();

        BT1.insert(1);
        BT1.insert(2);
        BT1.insert(5);
        BT1.insert(20);

        BT1.print_Ordered();

        BT1.delete(20);
        BT1.print_Ordered();
       
        
    }
}