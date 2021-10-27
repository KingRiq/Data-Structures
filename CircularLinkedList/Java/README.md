# Circular LinkedList
(These are my own words)

These are linkedlists but there is no "last" node.

My definition is a bit different... The first node is the same as the last node... the last node in the list points to the first... so whats the last node? There isn't one...

Think about it... 

1st->2nd->last-v
^-<-<-<-<-<-<-<-

Whats an empty list... an empty list
whats a list with one item in it... a node pointing to itself...

These are the things you should be thinking about! Its how you manipulate operations.

Adding.. make sure you update the "last" pointer to point to your new node.

Removal is the tricky part... You will see what I mean.

I had to look up what the uses for a circular LL is for... Someone said multiplayer... makes sense tbh... has to be more than 2 players though for it to make sense.