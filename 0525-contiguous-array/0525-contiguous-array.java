class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0,-1);
        int currsum = 0;
        int maxlen = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0){
                currsum += -1;
            }else{
                currsum += 1;
            }
            if(map.containsKey(currsum)){
                int len = i-map.get(currsum);
                maxlen = Math.max(len, maxlen);
            }else{
                map.put(currsum , i);
            }
        }
        return maxlen;
        
    }
}