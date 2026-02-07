public class SwappingLL{
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head=null;
   public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println("null");
    }
    public static void swapInLL(int x,int y){
        if(x==y)return ;

        Node prev1=null;
       Node currX=head;
       int i=0;
        while(currX!=null &&i<x){
            prev1=currX;
            currX=currX.next;
            i++;
        }
        Node prev2=null;
        Node currY=head;
        i=0;
        while(i<y&&currY!=null){
            prev2=currY;
            currY=currY.next;
            i++;
        }

        if(currX==null ||currY==null)return;

        if(prev1!=null)
        prev1.next=currY;
        else
        head=currY;

        if(prev2!=null)
        prev2.next=currX;
        else
        head=currX;

    Node temp =currX.next;
    currX.next=currY.next;
    currY.next=temp;

}
    public static void main(String args[]){
     head=new Node(10);
    Node first= new Node(20);
    Node second= new Node(30);
    Node third= new Node(40);
    Node fourth= new Node(50);
    head.next=first;
    first.next=second;
    second.next=third;
    third.next=fourth;
    print(head);
    swapInLL(2,4);
    print(head);
    }
}