class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int longest = 0;
        for(int i : set){
            if(!set.contains(i-1)){
                int streak = 1;
                int currNum = i;
                while(set.contains(currNum+1)){
                    currNum += 1;
                    streak += 1;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
        
    }
}