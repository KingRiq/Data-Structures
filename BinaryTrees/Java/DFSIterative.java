import java.util.*;

public class DFSIterative {

    public static void print(BinaryTree tree) {

        System.out.print("[");
        print_DFSIterative(tree.root);
        System.out.println("]");

    }

    private static void print_DFSIterative(BinaryTree.Node root) {

        // traverse iteratively we need a stack (since we are not using the stack frame)
        Stack<BinaryTree.Node> stack = new Stack<BinaryTree.Node>();
        BinaryTree.Node curr = root;

        // while we are not at the end or we still have nodes in our stack
        while (curr != null || stack.size() > 0) {

            // get our bottomost leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // curr had to be null to get here
            // the last node we pushed should be the node at the top of the stack
            curr = stack.pop();

            System.out.print(curr.data + " ");

            // if left == null then
            curr = curr.right;
        }
        // that was actually pretty intuitive

    }
}