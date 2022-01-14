public class InOrder {
    public static void print(BinaryTree tree) {
        System.out.print("[");
        print_InOrder(tree.root);
        System.out.println("]");
    }


    // Notes about Inorder (Left, Root, Right)
    private static void print_InOrder(BinaryTree.Node root){

        // do nothing otherwise
        if(root != null) {
            print_InOrder(root.left);
            System.out.print(root.data + " ");
            print_InOrder(root.right); 
        }

    }
}