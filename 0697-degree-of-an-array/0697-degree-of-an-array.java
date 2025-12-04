class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for(int i = 0; i<nums.length;i++){
            int x = nums[i];
            count.put(x,count.getOrDefault(x, 0) + 1);
             if(!first.containsKey(x)){
                first.put(x,i);
             }
             last.put(x,i);

             degree = Math.max(degree,count.get(x));

        }
        int ans = nums.length;
        for(int x : count.keySet()){
            if(count.get(x) == degree){
                int length = last.get(x) - first.get(x) + 1;
                ans = Math.min(ans,length);
            }
        }
        return ans;
    }
}