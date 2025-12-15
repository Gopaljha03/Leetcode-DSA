class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long len = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                len++;        // extend the descent
            } else {
                len = 1;      // start new descent
            }
            ans += len;       // add all periods ending here
        }
        return ans;
    }
}
