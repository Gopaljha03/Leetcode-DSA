import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        long[] prefixDp = new long[n + 1];
        prefixDp[0] = 1;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                left++;
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
            }

            long count;
            if (left == 0) {
                count = prefixDp[right];
            } else {
                count = (prefixDp[right] - prefixDp[left - 1] + MOD) % MOD;
            }

            dp[right + 1] = count;
            prefixDp[right + 1] = (prefixDp[right] + count) % MOD;
        }

        return (int) dp[n];
    }
}