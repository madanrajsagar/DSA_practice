public class evenOddseparateLL{
     public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
     }
     public static Node head;
     public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("null");
    }
   
   public static Node evenOddSeprate(Node head){
    if(head==null)
    return head;
    Node evenHead=null,evenTail=null;
    Node oddHead=null,oddTail=null;
    Node curr= head;

    while(curr!=null){
        if(curr.data%2==0){
            if(evenHead==null){
                evenHead=evenTail=curr;
            }else{
                evenTail.next=curr;
                evenTail=evenTail.next;
            }
        }else{
            if(oddHead==null){
                oddHead=oddTail=curr;
            }else{
                oddTail.next=curr;
                oddTail=oddTail.next;
            }
        }
        curr=curr.next;

    }

    if(evenHead==null)
    return oddHead;

     evenTail.next=oddHead;

    if(oddTail!=null)
        oddTail.next=null;
      
  return evenHead;

   }
    public static void main(String args[]){
   head=new Node(1);
    Node first= new Node(2);
    Node second= new Node(3);
    Node third= new Node(4);
    Node fourth= new Node(5);
    head.next=first;
    first.next=second;
    second.next=third;
    third.next=fourth;
    print(head);
    head=evenOddSeprate(head);
    print(head);

    }
}