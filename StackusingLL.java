import java.util.Stack;

public class StackusingLL{
    // public static class Node{
    //     int data;
    //     Node next;
    //    public Node(int data){
    //     this.data=data;
    //     this.next=null;
    //     }
    // }
    // public static class Stack{
    //     static Node head=null;

    //     public static boolean isEmpty(){
    //         return head==null;
    //     }
    //     public static void push(int data){
    //         Node newNode = new Node(data);
    //         if(isEmpty()){
    //           head=newNode;
    //           return; 
    //         }
          

    //         newNode.next=head;
    //         head=newNode;
    //     }            
    //     public static int pop(){
    //         if(isEmpty())
    //         return -1;

    //         int data=head.data;
    //         head=head.next;

    //         return data;
    //     }

    //     public static int peek(){
    //         if(isEmpty())
    //         return -1;

    //          return head.data;
    //     }
    // }
    //   public static void print(Node head){
    //     while(head!=null){
    //         System.out.print(head.data+"->");
    //         head=head.next;
    //     }
    //     System.out.println("null");
    // }

    public static void pushAtBottom(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }

        int top=s.pop();
        pushAtBottom(s,val);
        s.push(top);        
    }

    public static void main(String []args){
    // Stack st= new Stack();
    Stack<Integer> st = new Stack<>();
    // using JCF method

    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);
    pushAtBottom(st,50);
    // print(st.head);
    while(!st.isEmpty()){
        System.out.println(st.peek());
        st.pop();
    }
    }
}