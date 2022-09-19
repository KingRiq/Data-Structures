import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    int nodeCount;
    public Node root;

    public class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinaryTree() {
        root = null;
        nodeCount = 0;
    }

    public void insert(int data) {
        root = insert_Node(root, data); // always start at the root
    }

    private Node insert_Node(Node curr, int data) {

        // base case
        if (curr == null) {
            curr = new Node(data);
            return curr;
        }

        // recursive cases
        if (data < curr.data) // go left
            curr.left = insert_Node(curr.left, data);
        else if (data > curr.data)
            curr.right = insert_Node(curr.right, data);
        return curr;
    }

    public void delete(int data) {
        root = delete_Node(root, data);
    }

    Node delete_Node(Node curr, int data) {

        // base case (always check if the node is null or not [current node = the node
        // were on])
        if (curr == null) {
            return curr; // do nothing
        }

        if (data < curr.data)
            curr.left = delete_Node(curr.left, data);
        else if (data > curr.data) // else check right
            curr.right = delete_Node(curr.right, data);
        else { // it must equal this node right?

            // check if we are at the bottom
            if (curr.left == null && curr.right == null) {
                curr = null; // simply delete this node
                return curr;
            } else if (curr.left == null) // if not left then it must be right (vice versa)
                return curr.right;
            else if (curr.right == null)
                return curr.left;

            // two nodes exists lets find make the lesser our parent node (in the RIGHT
            // subtree)
            else {
                Node temp = minVal(curr.right);
                curr.data = temp.data;
                curr.right = delete_Node(curr.right, temp.data); // delete the min Node because curr is now it
                return curr;
            }

        }

        return curr;
    }

    public void print_Ordered() {
        System.out.print("[");
        inOrder(root);
        System.out.println("]");
    }

    void inOrder(Node curr) {

        if (curr != null) {
            inOrder(curr.left);
            System.out.print(curr.data + " ");
            inOrder(curr.right);
        }

    }

    Node minVal(Node curr) {
        Node min = curr;
        while (curr.left != null) {
            min = root.left;
            curr = curr.left;
        }
        return min;
    }

    public int getCount() {
        return nodeCount;
    }

    public int maxHeight() {
        // do a search to check max height
        // this will be non-recusrive but I will create a recursive verison as well

        int max = -1;
        // BFS seems the most intuitive since we will assess the height as one entity.
        // DFS would exam each height individually (for each path)
        // I also need to code these two as I'm unfamiliar... I should know this.

        // first create a queue
        Queue<Node> queue = new LinkedList<>();
        // start at root
        Node curr = root;
        queue.add(curr);

        // so while root is not null and queue isnt empty. Both means we are done
        // we can subtract the root level later
        while (root != null && !queue.isEmpty()) {

            // we need to process every level... this requires an inner loop.
            // Every outer loop processes a new height

            int size = queue.size();
            while (size > 0) {
                curr = queue.poll(); // why not use error checking this time around
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                size--;
            }
            max++;
        }

        return max; // root level doesnt count I've read... so root == 0 empty == -1
    }

    public void reset() {
        root = null;
        nodeCount = 0;
    }

    public void printAll_Traversals() {
        System.out.println("Printing All possible traversals");

        System.out.println("Starting PreOrder");
        PreOrder.print(this);
        System.out.println("PreOrder Complete");

        System.out.println("Starting InOrder");
        InOrder.print(this);
        System.out.println("InOrder Complete");

        System.out.println("Starting PostOrder");
        PostOrder.print(this);
        System.out.println("Post Order Complete");

        System.out.println("Starting DFS Iterative InOrder");
        DFSIterative.print(this);
        System.out.println("DFS Iterative Complete");

        System.out.println("Starting Breadth First Search");
        BFS.print(this);
        System.out.println("Breadth First Search Complete");

        /*
         * copy this for other traversals
         * 
         * System.out.println("Starting PostOrder");
         * PostOrder.print(this);
         * System.out.println("Post Order Complete");
         * 
         */

    }
}