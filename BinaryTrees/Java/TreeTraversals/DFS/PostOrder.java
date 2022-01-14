package DFS;
import BinaryTree.Node;

public class PostOrder implements TreeTraversals {
    public static void print(BinaryTree tree) {
        System.out.println("[");
        print_PreOrder(tree.root);
        System.out.println("]");
    }


    // Notes about post order (Left, Right, Root)
    private void print_PostOrder(Node root){

        // do nothing otherwise
        if(root != null) {
            print_PostOrder(root.left);
            print_PostOrder(root.right);
            System.out.print(root.data + " ");
        }

    }
}