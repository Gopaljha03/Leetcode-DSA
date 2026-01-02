class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    private int atMost(int[]nums, int k){
        int left = 0;
        
        int count = 0;
        Map<Integer, Integer>map = new HashMap<>();
        
        for(int right = 0; right<nums.length;right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num,0)+1);
            while(map.size()>k){
                int leftnum = nums[left];
                map.put(leftnum , map.get(leftnum)-1);

                if(map.get(leftnum)== 0){
                    map.remove(leftnum);
                }
                left++;
            }
            count +=right-left+1;
        }
        return count;
    }
}