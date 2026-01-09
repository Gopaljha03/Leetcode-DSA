class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<=n;i++){
            if(i == 1){
                dp[1] = dp[i-1]+0;
            }else{
                dp[i] = dp[i-1]+ dp[i-2];
            }
        }
        return dp[n];
    }
}
//MEMORIZATION
/*class Solution {
    public int climbStairs(int n) {
       int[] ways = new int[n+1];
       return dfs(n, ways);
        
    }
    private int dfs(int n, int[]ways){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(ways[n] !=0) return ways[n];

        ways[n] = dfs(n-1, ways)+dfs(n-2,ways);
        return ways[n];

    }
}*/