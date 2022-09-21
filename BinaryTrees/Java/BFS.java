package Type.SearchingAlgorithm;

import java.util.*;

public class BFS {
    public static void print(BinaryTree tree) {

        System.out.print("[");
        print_BFS(tree.root);
        System.out.println("]");
    }

    // this algorithm does not know what level it is on it merely prints in a BFS
    // way
    // because the queue will remove the nodes in the correct order this is by
    // contract of queue's structure.
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