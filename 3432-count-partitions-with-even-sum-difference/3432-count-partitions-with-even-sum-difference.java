class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i<=nums.length-1 ; i++){
            total = total+nums[i];

            

        }
        if(total % 2 == 0){
            return n-1;
        }
        return 0;
    }
}