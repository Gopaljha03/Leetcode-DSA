class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;
        
        HashMap<Integer, Integer> leftFreq = new HashMap<>();
        HashMap<Integer, Integer> rightFreq = new HashMap<>();
        
        
        for (int x : nums) {
            rightFreq.put(x, rightFreq.getOrDefault(x, 0) + 1);
        }
        
        long count = 0;
        
        for (int j = 0; j < n; j++) {
            int middle = nums[j];
            
            
            rightFreq.put(middle, rightFreq.get(middle) - 1);
            if (rightFreq.get(middle) == 0) {
                rightFreq.remove(middle);
            }
            
            int target = middle * 2;
            
            long left = leftFreq.getOrDefault(target, 0);
            long right = rightFreq.getOrDefault(target, 0);
            
            count = (count + (left * right) % mod) % mod;
            
            
            leftFreq.put(middle, leftFreq.getOrDefault(middle, 0) + 1);
        }
        
        return (int) count;
    }
}
