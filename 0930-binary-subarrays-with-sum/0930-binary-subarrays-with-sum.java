class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0,1);
        int currsum = 0;
        int count = 0;
        for(int num: nums){
            currsum +=num;

            if(map.containsKey(currsum - goal)){
                count+= map.get(currsum-goal);
            }
            map.put(currsum, map.getOrDefault(currsum, 0)+1);
        }
        return count;
    }
}
/*SLIDING WINDOW
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)- atmost(nums,goal-1);
        
    }
    public int atmost(int []nums, int goal){
        if(goal < 0) return 0;
        int left = 0;
        int sum = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count +=right-left+1;
        }
        return count;
    }
}*/