public class ZigzagLL{
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

    public static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;

    }

    public static Node zigZagLL(Node head){
        // 1. find the mid
        Node mid = getMid(head);

        // 2.reverse second half
        Node right = mid.next;
        mid.next=null;
        right=reverse(right);

        // 3. atl merge -zigzag

        Node left= head;
        Node nextL,nextR;
        while(left!=null&&right!=null ){
            // zigzag
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            // update
            left=nextL;
            right=nextR;
        }

        return head;
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
        head=zigZagLL(head);
        print();
    }
}