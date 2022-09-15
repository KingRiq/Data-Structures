
// binary search tree
public class BST extends BinaryTree {
    public BST() {

        // this is just a Binary tree with rules
        super();
    }

    // Binary search tree means our smallest valued nodes are located at the bottom
    // Recall Binary Trees dont really enforce order. (Or at least the one I made).
    // It was entirely dependent on what node we inserted first.
    // If we put 50 as root and entered every node of lesser value the right node of
    // root would be null.\
    // this will technically be a ordered tree where the highest node is the
    // furthest right leaf
    // the smallest will be the furthest left. (bottom most)

    // This will be my attempt to have a tree that is ALWAYS balanced. it will rebalance itself after almost every insertion... which is probably expensive.
    // our searches will always be optimized though



}