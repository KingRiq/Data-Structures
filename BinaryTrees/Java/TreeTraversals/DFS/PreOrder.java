package DFS;

import BinaryTree.Node;

public class PreOrder {
    public static void print(BinaryTree tree) {
        System.out.println("[");
        print_PreOrder(tree.root);
        System.out.println("]");
    }


    // Notes about pre order (Root, Left, Right)
    private void print_PreOrder(Node root) {

        // do nothing otherwise
        if(root != null) {
            System.out.print(root.data + " ");
            print_PreOrder(root.left);
            print_PreOrder(root.right);
        }

        // that's it I guess

    }
}