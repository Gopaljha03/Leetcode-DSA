class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int currsum = 0;
        int count = 0;
        for(int num : nums){
            currsum +=num;

            if(map.containsKey(currsum - k)){
                count += map.get(currsum- k);
            }
            map.put(currsum,map.getOrDefault(currsum, 0)+1);
        }
        return count;
    }
}
/*BRUTEFRCE
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i< n;i++){
            int sum = 0;
            for(int j = i; j<n;j++){
                sum += nums[j];

                if(sum == k){
                    count++;
                }
            }
        }
        return count;
        
    }
}*/