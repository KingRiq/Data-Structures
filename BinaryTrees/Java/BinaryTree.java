public class BinaryTree {
    int nodeCount;
    Node root;
    
    class Node {
        Node left, right;
        int data;

        Node(int data) {
           this.data = data;
           left = null;
           right = null; 
        }
    }

    BinaryTree() {
        root = null;
        nodeCount = 0;
    }

    public void insert(int data) {    
        root = insert_Node(root, data); //always start at the root
    }

    Node insert_Node(Node curr, int data) {
        
        //base case
        if (curr  == null) { 
            curr = new Node(data);
            return curr;
        }

        //recursive cases
        if(data < curr.data)    //go left
            curr.left = insert_Node(curr.left, data);
        else if (data > curr.data)
            curr.right =  insert_Node(curr.right, data);
        return curr;
    }

    public void delete(int data) {
        root = delete_Node(root , data);
    }

    Node delete_Node(Node curr, int data) {
        return null;
    }

}