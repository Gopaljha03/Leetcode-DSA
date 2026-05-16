class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0,1);
        int oddcount = 0;
        int ans = 0;
        for(int i =0; i < nums.length;i++){
            if(nums[i]%2 != 0){
                oddcount++;
            }
            ans += map.getOrDefault(oddcount - k, 0);
            map.put(oddcount, map.getOrDefault(oddcount, 0)+1);
        }
        return ans;
    }
}
/*SLIDING WINDOW
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
        
    }
    public int atmost(int []nums, int k){
        int left = 0;
        int oddcount = 0;
        int count = 0;
        for(int right = 0; right <nums.length;right++){
            if(nums[right] % 2 != 0){
                oddcount++;
            }
            while(oddcount > k){
                if(nums[left] %2 != 0){
                    oddcount--;
                }
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}*/