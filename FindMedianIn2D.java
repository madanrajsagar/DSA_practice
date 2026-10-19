public class FindMedianIn2D {
   public static int upperBound(int mat[],int x){
        int low=0;
        int high=mat.length-1;
        int mid=0;
        while(low<=high){
             mid=low+(high-low)/2;
            if(mat[mid]>x){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
   public static int countOfSmallEq(int mat[][] ,int n,int m,int x){
        int count=0;
        for(int i=0;i<n;i++){
            count+=upperBound(mat[i],x);
        }
        return count;
    }

   public static int findMedium(int mat[][]){
        int n=mat.length;
        int m=mat[0].length;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][m-1]);
        }
           int req=m*n/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int countOfEle=countOfSmallEq(mat,n,m,mid);
         
            if(countOfEle<=req){
                low=mid+1;

            }else{
                high=mid-1;
            }

        }
        return low;

    }
    public static void main(String[] args){
        int mat[][]={{1,3,5},
                    {2,6,9},
                    {4,8,10}};
           System.out.println(findMedium(mat)); 
    }
    
}
