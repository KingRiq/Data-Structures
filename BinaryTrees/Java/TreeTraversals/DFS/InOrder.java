package DFS;
import BinaryTree;

public class InOrder implements TreeTraversals {
    public static void print(BinaryTree tree) {
        System.out.println("[");
        print_InOrder(tree.root);
        System.out.println("]");
    }


    // Notes about Inorder (Left, Root, Right)
    private void print_InOrder(Node root){

        // do nothing otherwise
        if(root != null) {
            print_InOrder(root.left);
            System.out.print(root.data + " ");
            print_InOrder(root.right); 
        }

    }
}