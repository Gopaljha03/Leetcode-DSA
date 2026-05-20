class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currmax = nums[0];
        int maxsum = nums[0];
        int currmin = nums[0];
        int minsum = nums[0];
        int ans = 0;
        for(int i = 1; i <n;i++){
            currmax = Math.max(nums[i], currmax+nums[i]);
            maxsum =Math.max(maxsum,currmax);
        }
        for(int i = 1; i <n;i++){
            currmin= Math.min(nums[i], currmin+nums[i]);
            minsum = Math.min(minsum, currmin);
        }
        return ans = Math.max(Math.abs(maxsum), Math.abs(minsum));
    }
}