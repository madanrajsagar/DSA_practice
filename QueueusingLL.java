public class QueueusingLL{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public static class Queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null;
        }

        public static void enqueue(int data){
            Node newNode= new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        public static int dequeue(){
                if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }
                int val=head.data;
                if(head==tail){
                    head=tail=null;
            
                }else{
                    head=head.next;
                }
                return val;
        }

        public static int peek(){
             if(isEmpty()){
                    System.out.println("Queue is empty");
                    return -1;
                }
            return head.data;
        }
    }
    public static void main(String args[]){
        Queue q= new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}