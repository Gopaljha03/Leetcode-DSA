class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < k;i++){
            sum += nums[i];
            
        }
        int maxsum = sum;
        for(int i = k; i < n;i++){
            sum = sum - nums[i-k]+nums[i];
            maxsum = Math.max(maxsum , sum);
        }
        return (double)maxsum/k;

    }
}
/*BRUTE FORCE (TLE)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxavg = 0;
        for(int i =0; i <=n-k ;i++){
            int sum = 0;
            for( int j = i; j <i+k;j++){
                sum += nums[j];
            }
            maxavg = Math.max(maxavg, (double)sum/k);
        }
        return maxavg;
    }
}*/