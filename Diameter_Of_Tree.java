public class Diameter_Of_Tree{

     static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            
        }

    }

    public static int Height_Tree(Node root){
        if(root==null){
            return 0;
        }
        int lh=Height_Tree(root.left);
        int rh=Height_Tree(root.right);

        return Math.max(lh,rh)+1;
    }
    public static int diameter2(Node root){
        if(root==null){
            return 0;
        }
        int ldia=diameter2(root.left);
        int lh=Height_Tree(root.left);
        int rdia=diameter2(root.right);
        int rh=diameter2(root.right);

        return Math.max(Math.max(ldia,rdia),(lh+rh+1));
    }

    static class Info{
        int ht;
        int dia;
            Info(int ht,int dia){
                this.ht=ht;
                this.dia=dia;
            }
    }

    static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }

        Info linfo=diameter(root.left);
        Info rinfo=diameter(root.right);

        int dia=Math.max(Math.max(linfo.dia,rinfo.dia),(linfo.ht+rinfo.ht+1));
        int ht=Math.max(linfo.ht,rinfo.ht)+1;

        return new Info(ht,dia);

    }

    public static void main(String[] args) {
           Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        System.out.println("Height of Tree ="+ Height_Tree(root));
        Info dia=diameter(root);
        System.out.println("Diameter of Tree ="+ dia.dia);

    }
}