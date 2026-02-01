public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        size++;
        // step 1 - create new node
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        // step2 - link newnode to head
        newNode.next= head;

        // step3 - make newNode head
        head= newNode;

    }

    public void addLast(int data){
         size++;
        // step 1 : create a new node
        Node newNode = new Node(data);

        if(head==null){  //by convention you have to check for head for empty linkedlist
            head=tail=newNode;
        }

        // step 2 : tail.next = newNode
        tail.next= newNode;

        // step 3 :make newNode tail
        tail = newNode;
    }

    public void addMiddle(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        
        Node newNode= new Node(data);
        size++;
        Node prev = head;
        int i=0;

        while(i<idx-1){
            prev=prev.next;
            i++;
        }
        newNode.next=prev.next;
        prev.next=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        }else if(size ==1){
            int data= head.data;
            head=tail=null;
            size=0;
            return data;
        }

        
        int data=head.data;
        head= head.next;
        size--;
        return data;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int data=head.data;
            head=tail=null;
            size=0;
            return data;
        }

        Node prev=head;

        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int data= prev.next.data;
        prev.next=null;
        tail=prev;
       size--;
        return data;
        
    }

    public int itrSearch(int key){
        Node temp = head;

        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head,int key){    //TC =SC = O(n)
        // base case
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
       int idx= helper(head.next,key);

       if(idx==-1){
        return -1;
       }

       return idx+1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }

// IMP
    public void reverse(){
        Node prev =null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
        }

        head=prev;
    
    }
// IMP
    public void deleteNthfromEnd(int n){

        // calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
 
        if(n==sz){
            head=head.next;//remove first
            return;
        }

        // sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;

        while(i<iToFind){
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
    }   
    public void print(){
        if(head==null){
            System.out.println("Linked List is empty!");
            return;
        }

        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        LinkedList ll= new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(2, 3);
        ll.print();
        // ll.reverse();
        // System.out.println(size);
        ll.deleteNthfromEnd(1);
        ll.print();
        }
}