public class ClimbingStrairs {
public static int climb(int dp[],int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }

        dp[n]=climb(dp,n-1)+climb(dp,n-2);
        return dp[n];
    }

public static int countWaysTabu(int n){
    int dp[]= new int[n+1];
    dp[0]=1;
    for(int i=1;i<=n;i++){
        if(i==1){
            dp[i]=dp[i-1];
        }else{
            dp[i]=dp[i-1]+dp[i-2];
        }
    }
    return dp[n];
}
   
    public static void main(String[] args){
    int n=5;
    int dp[]= new int[n+1];
    System.out.println(climb(dp,n));
    System.out.println(countWaysTabu(n));
    
}
}
