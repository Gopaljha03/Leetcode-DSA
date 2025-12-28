class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int low = 0; 
        int high = 0;
        int sum = 0;
        while(high < n){
            sum += nums[high];

            while(sum >= target){
                int len = high-low+1;
                res = Math.min(res, len);

                sum = sum-nums[low];
                low++;
            }
            high++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}