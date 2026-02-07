import java.util.Stack;
public class ReverseStack{

    public static void pushAtBottom(Stack<Integer> s ,int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,val);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s,top);

    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());

        }
    }
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        printStack(st);
        
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        reverseStack(st);
        printStack(st);

    }
}