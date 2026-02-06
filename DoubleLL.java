public class DoubleLL{
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }

      
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
    }
    // remove
      public int removeFirst(){
        if(head==null){
            System.out.println("Linked List is empty!");
            return Integer.MIN_VALUE;
        }

          if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int data=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return data;

      } 

    //   reverse

    public void reverse(){
        Node curr= head;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    // print
    public void print(){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args){
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.print();
        dll.reverse();
        dll.print();
        System.out.println(size);

    }
}