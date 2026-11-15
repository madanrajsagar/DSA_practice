public class RodCutting {
    public static int findProfit(int[]len,int price[],int rodlen){
        int dp[][]= new int[price.length+1][rodlen+1];

        for(int i=0;i<price.length+1;i++){
            for(int j=0;j<rodlen+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }





            }
        }

        
       for(int i=1;i<price.length+1;i++){
            for(int j=1;j<rodlen+1;j++){
                if(len[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[price.length][rodlen];
    }
    public static void main(String args[]){
     int len[]={1,2,3,4,5,6,7,8};
     int price[]={1,5,8,9,10,17,17,20};
     int rodlength=8;

     System.out.println("Maximum profit after rod cutting is :"+findProfit(len,price,rodlength));
    }
}
