public class TransformToSumTree{
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

    public static int transform(Node root){
        if(root==null){
            return 0;
        }

        int leftChild= transform(root.left);
        int rightChild=transform(root.right);

        int data= root.data;
        int leftdata= (root.left == null)?0:root.left.data;
        int rightdata= (root.right== null)?0:root.right.data;

        root.data=leftChild+leftdata+rightChild+rightdata;
        
        return data;

    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]){

        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preorder(root);
        transform(root);
        System.out.println();
        preorder(root);
        
    }
}