class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count  = 0;
        for(int num : nums){
            if(count  == 0){
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

}    

/*BETTER
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer>countMap = new HashMap<>();

       
        int n =  nums.length;
        for(int num : nums){
            countMap.put(num , countMap.getOrDefault(num,0) + 1);
            if(countMap.get(num) > n/2){
                return num;
            }
        }
        return - 1;

    }
}
TLE (BRTEFORCE)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i =0; i<n;i++){
            int count = 0;
            for(int j  =0; j<n;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
                if(count > n/2){
                    return nums[i];
                }
            }
        }
        return -1;
    }

}*/
