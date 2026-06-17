public class H_BinaryTree_univalued{
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

        public static Boolean isUnivalued(Node root,int val){
            if(root==null){
                return true;
            }
            if(root.data!=val){
                return false;
            }

            Boolean left=isUnivalued(root.left, val);
            Boolean right=isUnivalued(root.right,val);

            return left && right;
        }
    public static void main(String[] args) {
         Node root = new Node(2);

        root.left = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(2);

        root.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(2);
    
        System.out.println("Give tree is univalues :"+isUnivalued(root,root.data));
    }
}