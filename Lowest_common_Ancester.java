import java.util.List;

import java.util.ArrayList;

public class Lowest_common_Ancester{
         static class Node {

            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }
        public static Boolean getPath(Node root,int n,List<Node> path){

            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }

            Boolean p1=getPath(root.left,n,path);
            Boolean p2=getPath(root.right,n,path);
            if(p1 || p2){
                return true;
            }

            path.remove(path.size()-1);

            return false;


        }

        public static Node LCS(Node root,int n1,int n2){
            List<Node> path1=new ArrayList<>(); 
            List<Node> path2=new ArrayList<>();
            getPath(root,n1,path1);
            getPath(root,n2,path2); 
            
            int i=0;
            for(;i<path1.size()&&i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
           
         return path1.get(i - 1);


        }

        public static Node LCS2(Node root, int n1,int n2){
            if(root==null||root.data==n1 ||root.data==n2){
                return root;
            }

            Node ln= LCS2(root.left,n1,n2);
            Node rn=LCS2(root.right,n1,n2);

            if(ln==null){
                return rn;
            }
            if(rn==null){
                return ln;
            }

            return root;
        }
    public static void main(String[] args) {
         Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("lowest common Ancester ="+LCS(root,4,5).data);
        System.out.println("lowest common Ancester ="+LCS2(root,4,7).data);
        
    }
}