class Solution {
    public int getMaxLen(int[] nums) {

        int maxLen = 0;
        int start = 0;

        while (start < nums.length) {

            
            while (start < nums.length && nums[start] == 0) {
                start++;
            }

            if (start >= nums.length) break;

            int end = start;

            int negativeCount = 0;
            int firstNegative = -1;
            int lastNegative = -1;

            
            while (end < nums.length && nums[end] != 0) {

                if (nums[end] < 0) {
                    negativeCount++;

                    if (firstNegative == -1) {
                        firstNegative = end;
                    }

                    lastNegative = end;
                }

                end++;
            }

            
            if (negativeCount % 2 == 0) {
                maxLen = Math.max(maxLen, end - start);
            }

            
            else {
                int leftLength = end - firstNegative - 1;
                int rightLength = lastNegative - start;

                maxLen = Math.max(maxLen, Math.max(leftLength, rightLength));
            }

            
            start = end + 1;
        }

        return maxLen;
    }
}


