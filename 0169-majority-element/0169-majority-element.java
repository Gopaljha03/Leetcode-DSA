class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);

            if(map.get(num) > n/2){
                return num;            }
        }
        return 0;
    }
}
/*class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}*/