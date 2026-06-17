public class Delete_Node_BST{
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

    public static Node deleteNode(Node root, int val){
        if(root.data<val){
            root.right=deleteNode(root.right, val);
        }else if(root.data>val){
           root.left= deleteNode(root.left, val);
        }else{
            // case 1
            if(root.left==null &&root.right==null){
                return null;
            }
            // case 2 : 1 child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            // case 3: 2 childrens
            Node ISNode=successorNode(root.right);
            root.data=ISNode.data;
            root.right=deleteNode(root.right, ISNode.data);
        }

        return root;
    }
    public static Node successorNode(Node root){
        while(root.left!=null){
            root=root.left;
        }
return root;
    }

    public static void main(String[] args) {
         int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        deleteNode(root, 5);
        System.out.println("");
        inorder(root);
    }
}
