class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int total = 0;

        // 1️⃣ Count already satisfied customers
        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0){
                total = total + customers[i];
            }
        }

        // 2️⃣ Sliding window to calculate customers saved by technique
        int windowSum = 0;
        int maxextra = 0;

        for(int i = 0; i < grumpy.length; i++){

            // Add customer if they were originally unsatisfied (grumpy = 1)
            if(grumpy[i] == 1){
                windowSum = windowSum + customers[i];
            }

            // Remove customer that goes out of the window
            if(i >= minutes && grumpy[i - minutes] == 1){
                windowSum = windowSum - customers[i - minutes];
            }

            // Track maximum extra satisfied customers
            if(windowSum > maxextra){
                maxextra = windowSum;
            }
        }

        // 3️⃣ Final result
        return total + maxextra;
    }
}
