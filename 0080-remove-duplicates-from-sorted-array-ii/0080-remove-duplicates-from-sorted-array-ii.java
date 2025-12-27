class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j = 2 ; j<n;j++){
            if(nums[i] != nums[j]){
                nums[i+2] = nums[j];
                i++;
            }
        }
        return(i+2);
    }
}