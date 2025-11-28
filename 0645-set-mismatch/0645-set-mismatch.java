class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        int duplicate = -1;
        int uniquesum = 0;
         for(int i = 0; i<nums.length;i++){
            if(set.contains(nums[i])){
                duplicate = nums[i];
            }else{
                set.add(nums[i]);
                uniquesum = uniquesum + nums[i];
            }
            


        }
        int expsum = n*(n+1)/2;

        int missing = expsum - uniquesum;

        return new  int[]{duplicate , missing};
    }
}