public class SubTree{
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

        static Boolean isIdentical(Node root ,Node subroot){
                if(root==null && subroot==null){
                    return true;                
                    }else if(root==null ||subroot==null ||root.data!=subroot.data){
                        return false;
                    }
                
                if(!isIdentical(root.left,subroot.left)){
                    return false;
                }
                if(!isIdentical(root.right, subroot.right)){
                    return false;
                }

                return true;
        } 

        static Boolean isSubtree(Node root,Node subroot){
            if(root==null){
               return false;
            }

            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }

            return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
        }
    
    
    
    public static void main(String[] args) {
    // tree
    Node root= new Node(1);
    root.left=new Node(2);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    
    root.right=new Node(3);
    root.right.right=new Node(6);
    
    // SubTree 

    Node subtree= new Node(2);
    subtree.left=new Node(4);
    subtree.right= new Node(5);

    System.out.println("Is the given tree Subtree ="+isSubtree(root,subtree));
        
    }
}