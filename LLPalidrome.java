
public class LLPalidrome {

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

    public void addFirst(int data) {
        size++;
        // step 1 - create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 - link newnode to head
        newNode.next = head;

        // step3 - make newNode head
        head = newNode;

    }

    public void addLast(int data) {
        size++;
        // step 1 : create a new node
        Node newNode = new Node(data);

        if (head == null) {  //by convention you have to check for head for empty linkedlist
            head = tail = newNode;
        }

        // step 2 : tail.next = newNode
        tail.next = newNode;

        // step 3 :make newNode tail
        tail = newNode;
    }

    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node prev = head;
        int i = 0;

        while (i < idx - 1) {
            prev = prev.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int data = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return data;

    }

    public int itrSearch(int key) {
        Node temp = head;

        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

   // Slow-Fast Approach
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }

        return fast;
    }

     public boolean cheakPalidrome(){
        if(head==null || head.next==null){
            return true;
        }
        // Step1 -finding the mid
         Node midNode =findMid(head);

        // step2 reverse the right half
            Node prev=null;
            Node curr=midNode;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }            
            
        // step3 compare left and right half
        Node left =head;
        Node right=prev;

        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }

        return true;
     }

    public void print() {
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

    public static void main(String args[]) {
        LLPalidrome ll = new LLPalidrome();
        ll.addLast(1);
        ll.addLast(2);
        // ll.addLast(2);
        ll.addLast(1);
        ll.print();

        System.out.println(ll.cheakPalidrome());
        
    }
}
