import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        while ((int) (Math.random() * 1000) != 0) {
            BT.insert((int) (Math.random() * 1000));
        }
        BT.print_Ordered();

        // I never once tried to delete anything... how thats very unlike me.
        // anyways...

        // Start over and be thorough

        BinaryTree BT1 = new BinaryTree();

        BT1.insert(1);
        BT1.insert(2);
        BT1.insert(5);
        BT1.insert(20);

        BT1.printAll_Traversals();

        BT1.delete(20);
        BT1.print_Ordered();
        BT1.delete(1);
        BT1.print_Ordered();
        BT1.delete(2);
        BT1.print_Ordered();
        BT1.delete(5);
        BT1.print_Ordered();
        BT1.delete(500); // check empty tree and number not in tree
        BT1.print_Ordered();
        BT1.insert(500);
        BT1.print_Ordered();
        BT1.delete(500);
        BT1.print_Ordered();

        // BT traversals
        BT1.insert(15);
        BT1.insert(2);
        BT1.insert(5);
        BT1.insert(20);

        BT1.printAll_Traversals();
        /*
         * 15
         * /\
         * 2 20
         * \
         * 5
         * 
         * pre [15,2,5,20] node, node left, node right
         * inorder [2,5,15,20]
         * post [ 5,2,20,15]
         */

        /*
         * [5]
         * /\
         * 3 10
         * 8 11
         * 7
         */

        BT1.reset();
        BT1.insert(5);
        BT1.insert(3);
        BT1.insert(10);
        BT1.insert(8);
        BT1.insert(7);
        BT1.insert(11);
        BT1.print_Ordered();
        BT1.delete(10);
        BT1.print_Ordered();
        System.out.println("Process complete");

        AbstractList<Integer> list = new ArrayList();

    }
}