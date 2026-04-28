class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(dp, n);
        

    
    }
    public int solve(int[]dp , int n){
        if(n == 0 || n==1)return 1;
        if(dp[n] != -1)return dp[n];
        dp[n] = solve(dp, n-1) + solve(dp, n-2);
        return dp[n];
    }
}
/*RECURSION
class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n==1){
            return 1;
        }
        return climbStairs(n-1)+ climbStairs(n-2);
    }
}*/