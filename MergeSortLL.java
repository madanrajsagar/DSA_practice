public class MergeSortLL {
public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static Node getMid(Node head){
        Node slow=head;
        Node fast =head.next;

        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
    return slow;

    }

    public static Node merge(Node left,Node right){

        Node mergedLL =new Node(-1);
        Node temp =mergedLL;
        while(left!=null && right !=null){
                if(left.data<right.data){
                    temp.next=left;
                    left=left.next;
                }else{
                    temp.next=right;
                    right=right.next;
                }
                temp=temp.next;
        }
        while(left!=null){
            temp.next=left;
           temp=temp.next;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            temp=temp.next;
            right=right.next;
        }

        return mergedLL.next;
    }

    public static Node mergeSort(Node head){

        // Base case
        if(head==null || head.next==null){
            return head;
        }
        // find mid
        Node mid= getMid(head);

        // left & right MS
        Node rightHead=mid.next;
        mid.next=null;  
        Node newLeft= mergeSort(head);
        Node newRight= mergeSort(rightHead);


        // merge
        return merge(newLeft,newRight);
    }
     public static void print() {
        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String args[]){
        Node simple = new Node(5);
        simple.next=new Node (9);
        simple.next.next=new Node (10);
        simple.next.next.next=new Node (3);
        simple.next.next.next.next=new Node (11);
        head=simple;
        print();
        head=mergeSort(head);
        print();
    }
}