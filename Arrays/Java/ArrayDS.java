import ArrayDS.*;


// this program demonstrates that I can make generic arrays of any type and turn them into stacks or queue. This example shows my ability to deal with dynamic types
public class ArrayDS {
    public static void main(String args[]) {

        int size = 5;
        StackArray<String> s = new StackArray<>(size);
        StackArray<Integer> a = new StackArray<>(size);
        StackArray<Character> i = new StackArray<>(size);
        StackArray<Double> r = new StackArray<>(size);
        StackArray<Float> e = new StackArray<>(size);
        System.out.println(s);
        s.push("hi");
        a.push(5);
        i.push('d');
        r.push(6.00);
        e.push((float)7);
        
        s.push("saira");

        
        s.push("beer");
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
        s.pop();
        System.out.println(s);
        System.out.println(s.isEmpty());
        s = new StackArray<>(10);
        while(!s.isFull()) {
            s.push("Hi");
        }
        System.out.println(s);
       
        while(!s.isEmpty()) {
            s.pop();
            
            System.out.println(s);
        }

        s.push("variable in s");
        QueueArray<String> saira = new QueueArray<>(size);

        saira.enqueue("Test! ");
        saira.enqueue("a ");
        saira.enqueue("just ");
        saira.enqueue("is ");
        saira.enqueue("This ");

        System.out.println(saira.isFull());
        System.out.println(saira);

        // empty queue
        while(!saira.isEmpty()) {
            System.out.println(saira.dequeue());
        }

        // As an aside I wanted to show that Object arrays hold different types and you dont know what output to expect at each index.
        System.out.println("-----");
    
        
        saira.enqueue("This will be the first element in our array for reference");
        Object array[] = new Object[size*2];
        int p = 0; // p is our pointer for assigning values into our array
        
        /*
        Object E = null;
        insert(array, E, p); // this shouldn't work because it is not our specified Class in the insert method
        */

        // these will work 
        p =insert(array, saira, p);
        p =insert(array, s, p);
        p =insert(array, a, p);
        p =insert(array, i, p);
        p =insert(array, r, p);
        p =insert(array, e, p);
        
        System.out.print('[');
        for(int z = 0; z< array.length; z++) {
            System.out.print(array[z] + ", ");
        }
        System.out.print(']'); //[This will be the first element in our array for reference, ]
        System.out.println("Process Complete");

    }
    public static int insert(Object array[], ArrayDSInterface object, int pointer) {
    
        if(object instanceof StackArray) {
            StackArray stack = (StackArray) object;
            while(pointer < array.length && !object.isEmpty()) {
            array[pointer] = stack.pop();
            pointer++;
            }  
        }
        else if(object instanceof QueueArray) {
            QueueArray queue = (QueueArray) object;
            while(pointer < array.length && !object.isEmpty()) {
                array[pointer] = queue.dequeue();
                pointer++;
            }
        }
        
        return pointer;
    }
}