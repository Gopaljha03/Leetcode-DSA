class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        // Step 1: check if every i>0 has complexity[i] > complexity[0]
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        // Step 2: compute (n-1)! modulo MOD
        long res = 1;
        for (int k = 1; k <= n - 1; k++) {
            res = (res * k) % MOD;
        }
        return (int) res;
    }
}
