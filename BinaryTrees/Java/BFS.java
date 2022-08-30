import java.util.*;

public class BFS {
    public static void print(BinaryTree tree) {

        System.out.print("[");
        print_BFS(tree.root);
        System.out.println("]");
    }

    public static void print_BFS(BinaryTree.Node root) {

        Queue<BinaryTree.Node> queue = new LinkedList<>();

        BinaryTree.Node curr = root;
        queue.add(root);
        // if root is null do nothing
        while (root != null && !queue.isEmpty()) {

            // dequeue the node
            curr = queue.remove();
            if (curr != null) {
                System.out.print(curr.data + " ");
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

        }
    }
}