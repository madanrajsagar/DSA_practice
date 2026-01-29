public class GridWays{
    public static int gridWay(int i,int j,int n,int m){
        // Base case
         if(i==n-1 && j==m-1){//last cell
            return 1;
         }
         else if(i==n ||j==n){
            return 0;
         }

         int w1=gridWay(i+1,j,n,m);//down way
         int w2=gridWay(i,j+1,n,m);//right way

         return w1+w2;
    }
    public static void main(String[] args){
        System.out.println("Total ways of grid is :"+gridWay(0,0,3,3));

    }
}