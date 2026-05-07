 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int[n-k+1];
        int max = nums[0];
        for(int i = 0; i <k ;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        result[0] = max;

        for(int i = 1; i <=n-k ;i++){
            int outgoing = nums[i-1];
            int incoming = nums[i+k-1];

            if(outgoing == max){
                max = nums[i];
                for(int j = i ; j <i+k;j++){
                    if(nums[j]> max){
                        max = nums[j];
                    }
                }
            }else{
                if(incoming > max){
                    max = incoming;
                }
            }
            result[i] = max;
        }
        return result;
       
        
    }
}
/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]result = new int[n-k+1];
        Deque<Integer>dq = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < n;i++){
            if(!dq.isEmpty() && dq.peekFirst() == i- k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();

            }
            dq.offerLast(i);

            if(i >=k-1){
                result[j++] = nums[dq.peekFirst()];
            }


        }
        return result;
       
        
    }
}*/