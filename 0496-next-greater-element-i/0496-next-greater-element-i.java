class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
            
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        int[]result = new int[nums1.length];
        for(int i =0; i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    

    
    
}
/*class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++){
            int current = nums1[i];
            int index = -1;

            for(int j = 0; j<nums2.length;j++){
                if(nums2[j] == current){
                    index = j;
                    break;
                }
            }
            int nextgreter = -1;
            for(int k = index+1; k<nums2.length;k++){
                if(nums2[k]>current){
                    nextgreter =  nums2[k];
                    break;
                }

            }
            result[i] = nextgreter;
        }
        return result;

        
    }
}*/