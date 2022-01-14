


// You may be wondering why made this an interface and instead of including it with its perspective class.
// Honestly it is to keep things modular and OOriented and because these things relate they are already coupled together so we don't care.
// Also in the coincedence when the data is related I can simply re-use it instead of implementing an entire data structure. If I want to decouple
// I can simply just set object as an input parameter and pass in THAT particular object... this adds complexity but increases re-usability.
// TL;DR Design choice/preference 
// (I am more interested in learning the ideas of these programs and not their implementation because I can always re-create them because I understand them)
// because of this learning tactic I learned this.

//import parent.BinaryTree;

// theoretically every method I create should know what a node is now...

interface TreeTraversals {

    public void print(); // simple enough right? I could also use polymorphism but I think thats just a flex (because they arent subclasses)... I need to practice it though.
}