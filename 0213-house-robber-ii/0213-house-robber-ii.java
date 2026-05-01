class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int case1 = solve(nums, 0,n-2);
        int case2 = solve(nums, 1, n-1);
        return Math.max(case1, case2);
    }
    private int solve(int [] nums, int start , int end){
        int n = nums.length;
        int [] dp = new int[n+2];
        for(int i = end ; i >= 0; i--){
            int take = nums[i] + dp[i+2];
            int notTake = dp[i+1];

            dp[i]= Math.max(take, notTake);
        }
        return dp[start];

    }
}
/*
MEMOIZATION
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[]dp2 = new int [n];

        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            solve(nums,0,n-2,dp1),
            solve(nums, 1, n-1, dp2)
        );
    } 
    private int solve(int [] nums, int i, int end,int[]dp){
        if(i > end)return 0;

        if(dp[i] != -1)return dp[i];
        int take = nums[i] + solve(nums, i+2,end,dp);
        int notTake =solve(nums, i+1,end,dp);

        return dp[i] = Math.max(take, notTake);
    }
}
RECURSION
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)return nums[0];
        return Math.max(
            solve(nums, 0 , n-2),
            solve(nums , 1, n-1)
        );
    }
    public int solve(int[] nums, int i, int end){
        if(i > end) return 0;

        int take = nums[i] + solve(nums , i+2, end);
        int notTake =  solve(nums,i +1, end);

        return Math.max(take, notTake);
    }
}*/ 