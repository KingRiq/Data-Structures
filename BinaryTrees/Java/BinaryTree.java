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

    public BinaryTree() {
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
        
        //base case
        if (curr == null) {
            return curr; //do nothing
        }
        
        if(data < curr.data) 
            curr.left = delete_Node(curr.left, data);
        else if (data < curr.data) 
            curr.right = delete_Node(curr.right, data);
        else {
            
            //check if we are at the bottom
            if(curr.left == null && curr.right == null) {
                curr = null; //simply delete this node
                return curr;
            }
            else if (curr.left == null) //if not left then it must be right (vice versa)
                return curr.right;
            else if (curr.right == null)
                return curr.left;
            
            // two nodes exists lets find make the lesser our parent node
            else {
                Node temp = minVal(curr.right);
                curr.data = temp.data;
                curr.right = delete_Node(curr.right, temp.data); //delete the min Node because curr is now it
                return curr;
            }
            
        }
        return curr;
    }

    public void print_Ordered() {
        inOrder(root);
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
}