public class TwoLLIntersecNode {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node intersection(Node head1,Node head2){
        while(head1!=null){
            Node temp=head2;
            while(temp!=null){
                if(temp==head1){
                    return head1;
                }
                temp=temp.next;
            }
            head1=head1.next;
        }
        return null;
    }

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        Node head1,head2;
        head1=new Node(10);
        head2=new Node(20);
        Node ll1first=new Node(30);
        Node ll2first=new Node(40);
        Node ll1sec=new Node(50);
        Node ll2sec=new Node(60);
        Node ll1third=new Node(70);
        Node ll2third=new Node(80);
        
        Node both1= new Node(90);
        Node both2= new Node(100);

        head1.next=ll1first;
        head2.next=ll2first;
        ll1first.next=ll1sec;
        ll2first.next=ll2sec;
        ll1sec.next=ll1third;
        ll2sec.next=ll2third;
        
        ll1third.next=both1;
        ll2third.next=both1;
        
        both1.next=both2;

        Node intersection=intersection(head1,head2);

        print(head1);
        print(head2);
        
    if(intersection==null){
        System.out.println("No Intersection exist!");
    }else{
        System.out.println("Intersectd Node Data :"
        +intersection.data);
    }
        
    }
}