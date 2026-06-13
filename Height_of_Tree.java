public class Height_of_Tree{
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
        public static int treeHeight(Node root){
            if(root==null){
                return 0;
            }
            int lh=treeHeight(root.left);
            int rl=treeHeight(root.right);

            return Math.max(lh,rl)+1;
        }

        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int lc=countNodes(root.left);
            int rc=countNodes(root.right);

            return (lc+rc+1);
        }

        public static int sumOfNodes(Node root){
                if(root ==null){
                    return 0;
                }

                int lsum= sumOfNodes(root.left);
                int rsum=sumOfNodes(root.right);

                return (lsum+rsum+root.data);
        }

     
    public static void main(String args[]){

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
    
        System.out.println("Height of the Tree is ="+treeHeight(root));
        System.out.println("Count of nodes ="+countNodes(root));
        System.out.println("Sum of nodes ="+sumOfNodes(root));
        
        
        
        }
}