
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Top_view_of_Btree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
         this.data=data;
         left=null;
         right=null;
        }
    }

        static class Info{
            int hd;
            Node node;

                Info(int hd,Node node){
                    this.hd=hd;
                    this.node=node;
                }        
            }

     static void topViewBtree(Node root){
        HashMap<Integer,Node> map= new HashMap<>();
        Queue<Info> q= new LinkedList<>();

        q.add(new Info(0,root));
        q.add(null);
        int min=0;
        int max=0;

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                        continue;
                    }
            }

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }

            if(curr.node.left!=null){
                q.add(new Info(curr.hd-1,curr.node.left));
                min=Math.min(min,curr.hd-1);
            }

            if(curr.node.right!=null){
                q.add(new Info(curr.hd+1,curr.node.right));
                max=Math.max(max,curr.hd+1);
            }
            
        }
        System.out.print("Following is the top view for the tree :-");
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+"->");
        }

    }

    
    public static void main(String[] args) {
    
        Node root= new Node(1);

        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right= new Node(3);
        root.right.left= new Node(6);
        root.right.right= new Node(7);
         
        topViewBtree(root);
    }
}