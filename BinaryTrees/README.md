Binary trees are a tree structure where for every node has at most 2 child leaves.

so given a tree

   [1] is a  valid binary tree

   [1]
   / \
 [2] [3] is a valid tree

     [1]
    / | \
  [2][3][4] is not a valid binary tree. (These are enough edge examples to convince myself but here are a few more)


  [1]
  / \
[2] [3]  is a valid binary tree. Listen up and listen good! Every node except the root must have one parent as well... I guess thats 
  \      important because otherwise it would be a graph. A graph with no cycles is basically a tree. We can effectively say that
  [5]    every tree is by definition a graph but not every graph is a tree.


        [1]
      /     \
    [2]    [3]
    /\     /
  [4][5]  [7]  This was arbitrary but guess what... not a valid binary tree.
         / | \
       [6][9][20]


So a node will have both a left and right pointer which will either be null or will point to a child. I guess you could doubly link the tree. Im interested in these implications.. wait I already answered that It would just be a graph. You just would "Know" that it is the parent of that node.


Alot of the problem solving solutions using trees revolve around recursion and searching algorithms. I have already covered them but I wanted to review them in a deeper readme because they are so important.

Note:
Imagine a binary tree that has denegerated (that is what they are called degenerated binary tree). Think about removal of a node.

        [1]
      /     \
    [2]    [3]
    /\     /
  [4][5]  [7]   Imagine a world where I want to delete a bunch of nodes... say 9, 7 3 how would that look?
         /  \
       [6] [9]

Now its easy to see that Binary Trees need structure re-enforcement... 
In school they taught us nodes of lesser value make sense at the bottom.


        [4]
      /     \
    [2]    [6]
    /\     / \
  [1][3]  [5] [7]  What the heck! This makes no sense right? but with an enforcement we can kinda decide how things should be handled.

  in a typical binary tree you must decide how to insert how to delete and that is basically the rules of what the problem needs.

  for this particular tree nodes go in this order.  Starting from the root! if a number is less than the root then it goes to root.left. if it is greater than or equal to if goes to root.right and using this logic you can see how the tree was built. This enforcement gives us power.  We not know what happens when we should delete 7

        [4]
      /     \
    [2]    [6]
    /\     / \              Easy right? ok what if we did 6 instead!
  [1][3]  [5] [null]


        [4]
      /     \
    [2]    [6]             We need more rules! This is up to you. I wont tell you how to do your job! I am just going to replace it with
    /\     / \             the node.right because is makes sense. But you can see how this may be a problem. what is the tree ws bigger...
  [1][3]  [5] [7]           Were spending alot of time repositioning our nodes... enforcing order is expensive!


         [10]
       /      \
     [4]     [12]             Look at the chaos of deleting 4
    /   \     /  \            
  [2]   [6] [11]  [13]
  / \    / \
[1] [3][5] [7]



         [10]
       /      \
     [5]     [12]             Look at all that work lol. I am learning that this is actually a binary search tree and not just a binary tree.
    /   \     /  \            I will implement this later. When I have free time.
  [2]   [7] [11]  [13]
  / \    / 
[1] [3][6]