import java.util.ArrayList;
import java.util.List;
public class BST_tree{
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

    public static Boolean search(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.data==val){
            return true;
        }
        if(root.data>val){
            return search(root.left, val);
        }else{
            return search(root.right,val);
        }      
    }

    int sum;
    public int rangeSumBST(Node root, int low, int high) {
        if(root==null){
            return 0;
            }
        if(low<=root.data &&root.data<=high){
            rangeSumBST(root.left,low,high);
            sum+=root.data;
            rangeSumBST(root.right,low,high);
        }else if(root.data<low){
            rangeSumBST(root.right,low,high);
        }else{
            rangeSumBST(root.left,low,high);
        }

        return sum;
    }

    public static void printList(List<Integer> ls){
        for(Integer i:ls){
            System.err.print(i+" ");
        }
        System.out.println("");
    }
    public static void root2Leaf(Node root,List<Integer> ans){
        if(root==null){
            return;
        }

        ans.add(root.data);
        if(root.left==null&&root.right==null){
            printList(ans);
        }
        root2Leaf(root.left,ans);
        root2Leaf(root.right,ans);
        ans.remove(ans.size()-1);


    }

    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        if(search(root,26)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        inorder(root);
        root2Leaf(root,new ArrayList<>());
    }
}