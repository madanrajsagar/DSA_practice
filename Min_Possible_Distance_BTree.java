public class Min_Possible_Distance_BTree{
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

        
    public static Node LCS2(Node root, int n1,int n2){
            if(root==null||root.data==n1 ||root.data==n2){
                return root;
            }

            Node ln= LCS2(root.left,n1,n2);
            Node rn=LCS2(root.right,n1,n2);

            if(ln==null){
                return rn;
            }
            if(rn==null){
                return ln;
            }

            return root;
        }
        public static int dist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            
            int ls=dist(root.left,n);
            int rs=dist(root.right,n);

            if(ls==-1 && rs==-1){
                return -1;
            }else if(ls==-1){
                return rs+1;
            }else{
                return ls+1;
            }
        }

        public static int min_Distance(Node root,int n1,int n2){
            Node lca=LCS2(root,n1,n2);
            int dist1= dist(lca,n1);
            int dist2=dist(lca,n2);

            return dist1+dist2;
        }
    public static void main(String args[]){
         Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Mininum distance betn 2 nodes : "+min_Distance(root,4,5));


    }
}