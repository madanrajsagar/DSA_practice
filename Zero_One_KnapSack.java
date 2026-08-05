public class Zero_One_KnapSack{
    public static int _0_1_knapsackR(int n,int []wt,int val[],int w){
        if(n==0||w==0){
            return 0;
        }

        if(wt[n-1]<=w){
           int ans1= val[n-1]+_0_1_knapsackR(n-1,wt,val,w-wt[n-1]);
        //    include case

        int ans2=_0_1_knapsackR(n-1, wt, val, w);
        // exclude consition
        return Math.max(ans1,ans2);
        }
        else{
            return _0_1_knapsackR(n-1, wt, val, w);
        }
    }

    public static int _0_1_knapsackWithMemo(int n,int []wt,int val[],int w,int [][]dp){
            if(n==0||w==0){
            return 0;
        }

        if(dp[n][w]!=-1){
            return dp[n][w];
        }

        
        if(wt[n-1]<=w){
           int ans1= val[n-1]+_0_1_knapsackWithMemo(n-1,wt,val,w-wt[n-1],dp);
        //    include case

        int ans2=_0_1_knapsackWithMemo(n-1, wt, val, w,dp);
        // exclude consition
        dp[n][w]=Math.max(ans1,ans2);
        return dp[n][w];
        }
        else{
            
        dp[n][w]= _0_1_knapsackWithMemo(n-1, wt, val, w,dp);
        return dp[n][w];
        }
   

    }

    public static int knapsackTabu(int wt[],int val[],int w){
       int n=val.length;
        int dp[][]= new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 ||j==0){
                    dp[i][j]=0;
                }
            }
        }
    
    
         for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
               int v=val[i-1];
               int wtt=wt[i-1]; 

               if(wtt<=j){
                    int ans1=v+dp[i-1][j-wtt];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
               }else{
                    dp[i][j]=dp[i-1][j];
               }
            }
        }

        return dp[n][w];
    
    }
    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;

        System.out.println(_0_1_knapsackR(val.length,wt,val,w));
        
        int dp[][]= new int[val.length+1][w+1];
        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
    System.out.println(_0_1_knapsackWithMemo(val.length,wt,val,w,dp));
      
    System.out.println(knapsackTabu(wt,val,w));
      
        
    }
}