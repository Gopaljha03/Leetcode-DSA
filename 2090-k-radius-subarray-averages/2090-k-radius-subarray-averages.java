class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        int windowsize = 2*k+1;
        if(windowsize > n)return ans;

        long windowsum = 0;

        for(int i = 0; i<windowsize;i++){
            windowsum = windowsum+nums[i];
        }
        ans[k] = (int)(windowsum/windowsize);

        for(int i = windowsize; i<n; i++){
            windowsum += nums[i];
            windowsum = windowsum - nums[i - windowsize];

            int center = i - k;
            ans[center] = (int)(windowsum/windowsize);
        }
        return ans;
    }
}