public class LongestCommonSubsequence {
    public static int LCS(String s1,String s2,int l1, int l2){
        if(l1==0||l2==0){
            return 0;
        }
        if(s1.charAt(l1-1)==s2.charAt(l2-1)) {
            return LCS(s1, s2, l1-1, l2-1)+1;            
        }else{
            int ans1=LCS(s1, s2, l1-1, l2);
            int ans2=LCS(s1, s2, l1, l2-1);
            return Math.max(ans1,ans2);
        }
    }
    public static int LCSMemo(String s1,String s2,int l1,int l2,int[][]dp){
        if(l1==0||l2==0){
            return 0;
        }
        if(dp[l1][l2]!=0){
            return dp[l1][l2];
        }
        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            dp[l1][l2]=LCSMemo(s1, s2, l1-1, l2-1, dp)+1;
                        return dp[l1][l2];

        }else{
            int ans1=LCSMemo(s1, s2, l1-1, l2, dp);
            int ans2=LCSMemo(s1, s2, l1, l2-1, dp);
            dp[l1][l2]=Math.max(ans1,ans2);
            return dp[l1][l2];
        }
    }

    public static int LCSTabu(String s1,String s2,int l1,int l2,int dp[][]){
        for(int i=0;i<l1+1;i++){
            dp[i][0]=0;
        }
         for(int i=0;i<l2+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
    public static void main(String args[]){
        String s1="abcde";
        String s2="ace";
        int dp[][]=new int[s1.length()+1][s2.length()+1];


        System.out.println("Longest Common subsequence : "+LCSTabu(s1,s2,s1.length(),s2.length(),dp));
        
        System.out.println("Longest Common subsequence : "+LCSMemo(s1,s2,s1.length(),s2.length(),dp));

        System.out.println("Longest Common subsequence : "+LCS(s1,s2,s1.length(),s2.length()));
    }
    
}
