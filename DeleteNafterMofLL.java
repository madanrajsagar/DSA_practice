public class DeleteNafterMofLL{
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void deleteNafterM(Node head,int m,int n)
    {
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            for(int i=0;i<m&&curr!=null;i++){
                prev=curr;
                curr=curr.next;
            }
            for(int j=0;j<n&&curr!=null;j++){
                curr=curr.next;
            }
            prev.next=curr;

        }

    }
       public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("null");
    }
public static void main(String args[])
{
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

    // Two LL are there

    System.out.print("LL before:");
    print(head1);
    deleteNafterM(head1,2,1);
    System.out.println();
    System.out.print("LL After:");
    print(head1);
 

}
    
}