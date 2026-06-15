
import java.util.LinkedList;
import java.util.Queue;



      public class Kth_level_BTree {

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

        public static void kth_level(Node root, int k) {

            int count = 0;
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();

                if (count == k) {
                    for (int i = 0; i < size; i++) {
                        System.out.print(q.remove().data + " ");
                    }
                    return;
                }
                for (int i = 0; i < size; i++) {
                    Node curr = q.remove();

                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);

                    }
                }
                count++;

            }

        }

        public static void kth_level_R(Node root , int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }

            kth_level_R(root.left,level+1,k);
            kth_level_R(root.right,level+1,k);
        }
    

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        kth_level(root,2);System.out.println("");
        kth_level_R(root,1,3);
        
    }
}
