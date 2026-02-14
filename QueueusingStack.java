import java.util.Stack;
public class QueueusingStack{
    public static class Queue{
       static Stack<Integer>st1= new Stack<>();
        static Stack<Integer>st2= new Stack<>();
        
        public static boolean isEmpty()
        {
            return st1.isEmpty();
        }
// add O(n)
    public static void add(int data){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(data);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }

    }
    // O(1)
    public static int remove()
    {   if(st1.isEmpty()){
        System.out.println("Queue is empty!");
        return -1;
    }
    return st1.pop();
    }

    public static int peek()
    {   if(st1.isEmpty()){
        System.out.println("Queue is empty!");
        return -1;
    }
    return st1.peek();
    }
    
    }

    public static void main(String args[]){
        Queue q= new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.st1.isEmpty()){
            System.out.println(q.st1.pop());
        }

    }
}