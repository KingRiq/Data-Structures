public class PostOrder {
    public static void print(BinaryTree tree) {
        System.out.print("[");
        print_PostOrder(tree.root);
        System.out.println("]");
    }


    // Notes about post order (Left, Right, Root)
    private static void print_PostOrder(BinaryTree.Node root){

        // do nothing otherwise
        if(root != null) {
            print_PostOrder(root.left);
            print_PostOrder(root.right);
            System.out.print(root.data + " ");
        }

    }
}