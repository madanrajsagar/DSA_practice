import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB{

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

    static class BinaryTree{
        static int idx=-1;
        public static Node BuildBinaryTree(int nodes[]){
            idx++;
            if(-1==nodes[idx]){
                return null;
            }
        Node newNode =new Node(nodes[idx]);
         newNode.left=BuildBinaryTree(nodes);
         newNode.right=BuildBinaryTree(nodes);
         
         return newNode;
        }

        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
          public static void inOrder(Node root){
         if(root==null){
            return;
         }
         inOrder(root.left);
         System.out.print(root.data+" ");
         inOrder(root.right);
          }

          public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");

          }

        // Level order traversal
          public static void levelorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode= q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                    
                }
            }


          }
    }
  

    public static void main(String args[]){
        int []nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
        BinaryTree btree= new BinaryTree();

        Node root=btree.BuildBinaryTree(nodes);
        btree.preOrder(root);
        System.out.println();
        btree.inOrder(root);
        System.out.println();
        btree.postOrder(root);
        System.out.println("***** Level order *****");
        btree.levelorder(root);

    }
}