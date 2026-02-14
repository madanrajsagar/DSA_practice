import java.util.LinkedList;
import java.util.Queue;
public class StackusingQueues{
    public static class Stack{
       static Queue<Integer>qu1= new LinkedList<>();
        static Queue<Integer>qu2= new LinkedList<>();

        public static boolean isEmpty(){
            return qu1.isEmpty()&&qu2.isEmpty();
        }

        public static void push(int data){
            if(!qu1.isEmpty()){
                qu1.add(data);
            }else{
                qu2.add(data);
            }

        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Stakc is empty!");
                return -1;
            }
            int top=-1;         
            if(!qu1.isEmpty()){
            while(!qu1.isEmpty()){
                top =qu1.remove();
                if(qu1.isEmpty()){
                 break;
                }
                qu2.add(top);
            }
            }else{
                while(!qu2.isEmpty()){
                    top= qu2.remove();
                    if(qu2.isEmpty()){
                        break;
                    }
                    qu1.add(top);
                }
            }
            
        return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Stakc is empty!");
                return -1;
            }
            int top=-1;     
                //case 1 
            if(!qu1.isEmpty()){
            while(!qu1.isEmpty()){
                top =qu1.remove();
                qu2.add(top);
            }
            }else{  //case 2
                while(!qu2.isEmpty()){
                    top= qu2.remove();
                    qu1.add(top);
                }
            }
            
        return top;
        }

    }

public static void main(String args[]){

    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);

    while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
    }
}
}