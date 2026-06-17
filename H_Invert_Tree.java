import java.util.LinkedList;
import java.util.Queue;
public class H_Invert_Tree{
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

        public static void invertTree(Node root) {

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr.left!=null){
                q.add(curr.left);
            } 
            if(curr.right!=null){
                q.add(curr.right);
            }
            Node temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;

        }
        
    }
        public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
           Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preorder(root);
        invertTree(root);
        preorder(root);
    }
}