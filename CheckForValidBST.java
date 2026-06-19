public class CheckForValidBST{
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
    public static Boolean checkBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        
        if(min!=null && min.data>=root.data){
            return false;
        }
        if(max!=null && max.data<=root.data){
            return false;
        }

        return checkBST(root.left,min,root)&&checkBST(root.right,root,max);
    } 
    
    public static void main(String[] args) {
     int values[]={5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
      
    System.out.println(checkBST(root, null, null));
}
}