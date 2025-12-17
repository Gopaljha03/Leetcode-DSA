import java.util.Arrays;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n < 2) return 0;

        // Optimization: Since each transaction takes at least 2 days (buy/sell on different days)
        // and transactions cannot overlap/touch on the same day, the max possible transactions is n/2.
        if (k > n / 2) {
            k = n / 2;
        }

        // DP State: dp[t][state]
        // t: Number of transactions completed so far (0 to k)
        // state 0: Free (Not holding any stock)
        // state 1: Holding Long (Bought stock, looking to sell)
        // state 2: Holding Short (Sold stock, looking to buy back)
        long[][] dp = new long[k + 1][3];

        // Initialize with a sufficiently small number to represent unreachable states.
        // We use Long.MIN_VALUE / 2 to avoid overflow when adding/subtracting prices.
        long INF = Long.MIN_VALUE / 2;
        
        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base Case: Day 0, 0 transactions completed, Free state.
        dp[0][0] = 0;

        for (int price : prices) {
            long[][] nextDp = new long[k + 1][3];
            
            // Initialize nextDp with current values (Case: Do nothing on this day)
            for (int i = 0; i <= k; i++) {
                nextDp[i][0] = dp[i][0];
                nextDp[i][1] = dp[i][1];
                nextDp[i][2] = dp[i][2];
            }

            for (int t = 0; t <= k; t++) {
                // 1. OPENING Transactions (Transition from Free -> Holding)
                // We do this based on 'dp' (previous day), so we don't open and close on the same day.
                if (dp[t][0] != INF) {
                    // Start Normal Transaction: Buy stock (-price)
                    // Move from Free (0) to Holding Long (1)
                    nextDp[t][1] = Math.max(nextDp[t][1], dp[t][0] - price);

                    // Start Short Transaction: Sell stock (+price)
                    // Move from Free (0) to Holding Short (2)
                    nextDp[t][2] = Math.max(nextDp[t][2], dp[t][0] + price);
                }

                // 2. CLOSING Transactions (Transition from Holding -> Free)
                // Completing a transaction moves us to count 't + 1'
                if (t + 1 <= k) {
                    // Close Normal Transaction: Sell stock (+price)
                    if (dp[t][1] != INF) {
                        nextDp[t + 1][0] = Math.max(nextDp[t + 1][0], dp[t][1] + price);
                    }

                    // Close Short Transaction: Buy back stock (-price)
                    if (dp[t][2] != INF) {
                        nextDp[t + 1][0] = Math.max(nextDp[t + 1][0], dp[t][2] - price);
                    }
                }
            }
            // Move to the next day
            dp = nextDp;
        }

        // The answer is the maximum profit in the 'Free' state for any number of transactions up to k
        long maxProfit = 0;
        for (int t = 0; t <= k; t++) {
            maxProfit = Math.max(maxProfit, dp[t][0]);
        }

        return maxProfit;
    }
}