
import java.rmi.server.RemoteObjectInvocationHandler;

public class BST_Mirror{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }

        if(root.data>val){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }

        return root;
    }

    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }

        Node left=mirrorBST(root.left);
        Node right=mirrorBST(root.right);

        root.left=right;
        root.right=left;

        return root;

    }

   public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        mirrorBST(root);
        System.out.println("");
        inorder(root);

        
    }
}