package Type.SearchingAlgorithm;

public class DFS {

    public static void preOrder(BinaryTree tree) {
        System.out.print("[");
        print_PreOrder(tree.root);
        System.out.println("]");
    }

    // Notes about pre order (Root, Left, Right)
    private static void print_PreOrder(BinaryTree.Node root) {

        // do nothing otherwise
        if (root != null) {
            System.out.print(root.data + " ");
            print_PreOrder(root.left);
            print_PreOrder(root.right);
        }

        // that's it I guess

    }

    public static void postOrder(BinaryTree tree) {
        System.out.print("[");
        print_PostOrder(tree.root);
        System.out.println("]");
    }

    // Notes about post order (Left, Right, Root)
    private static void print_PostOrder(BinaryTree.Node root) {

        // do nothing otherwise
        if (root != null) {
            print_PostOrder(root.left);
            print_PostOrder(root.right);
            System.out.print(root.data + " ");
        }

    }

    public static void inOrder(BinaryTree tree) {
        System.out.print("[");
        print_InOrder(tree.root);
        System.out.println("]");
    }

    // Notes about Inorder (Left, Root, Right)
    private static void print_InOrder(BinaryTree.Node root) {

        // do nothing otherwise
        if (root != null) {
            print_InOrder(root.left);
            System.out.print(root.data + " ");
            print_InOrder(root.right);
        }

    }
}