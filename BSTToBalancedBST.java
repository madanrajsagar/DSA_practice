
import java.util.ArrayList;
import java.util.List;
public class BSTToBalancedBST{
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

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void BSTtoArr(Node root,List<Integer> in){
        if(root==null){
            return;
        }
        BSTtoArr(root.left,in);
        in.add(root.data);
        BSTtoArr(root.right, in);

    }
    public static Node ALtoBalBST(List<Integer> in,int st,int ed){
        if(st>ed){
            return null;
        }
        int mid=(st+ed)/2;
        Node root= new Node(in.get(mid));
        Node left=ALtoBalBST(in,st,mid-1);
        Node right=ALtoBalBST(in,mid+1,ed);
        root.right=right;
        root.left=left;
    return root;
    }
    public static Node BST_to_BalBST(Node root){
        List<Integer> in = new ArrayList<>();
        BSTtoArr(root,in);
        return ALtoBalBST(in,0,in.size()-1);

    }

    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }

           inorder(BST_to_BalBST(root));
    }
}