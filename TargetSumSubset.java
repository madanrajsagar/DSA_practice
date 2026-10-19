public class TargetSumSubset {

    public static boolean IStargetSumSubset(int values[],int target){
        boolean dp[][]=new boolean[values.length+1][target+1];
        for(int i=0;i<values.length+1;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<values.length+1;i++){
            for(int j=1;j<target+1;j++){
                int val=values[i-1];
                // include current value
                if(val<=j && dp[i-1][j-val]==true){
                    dp[i][j]=true;
                }else if(dp[i-1][j]==true){
                    // excluding current value
                    dp[i][j]=true;
                }
            }
        
        }


        return dp[values.length][target];
    }
    public static void main(String args[]){
        int values[]={4,2,7,1,3};
        int target=5;
        System.out.println(IStargetSumSubset(values,target));
    }
    
}
