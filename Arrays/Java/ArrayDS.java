import ArrayDS.StackArray;
import ArrayDS.QueueArray;



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

    
        System.out.println(s);
        QueueArray<String> saira = new QueueArray<>(size);

        saira.enqueue("Test! ");
        saira.enqueue("a ");
        saira.enqueue("just ");
        saira.enqueue("is ");
        saira.enqueue("This ");
        System.out.println(saira.isFull());
        while(!saira.isEmpty()) {
            System.out.print(saira.dequeue());
        }
        System.out.println();
    }
    
}