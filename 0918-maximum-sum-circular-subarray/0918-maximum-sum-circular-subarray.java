class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currmax = nums[0];
        int maxsum = nums[0];
        int currmin= nums[0];
        int minsum = nums[0];
        int totalsum = 0;
        int circularmax = 0;
        for(int i = 0; i<n;i++){
            totalsum += nums[i];
        }
        for(int i = 1;i <n;i++){
            currmax = Math.max(nums[i], currmax+nums[i]);
            maxsum = Math.max(maxsum, currmax);
            
        }
        for(int i = 1; i < n;i++){
            currmin = Math.min(nums[i], currmin+nums[i]);
            minsum = Math.min(minsum, currmin);
        }
        if(maxsum < 0){
            return maxsum;
        }
        circularmax = totalsum - minsum;
        return Math.max(maxsum , circularmax);

         
        
    }
}