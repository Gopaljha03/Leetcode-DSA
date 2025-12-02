class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {

        // Count how many points lie on each horizontal line (each y-value)
        Map<Integer, Long> countY = new HashMap<>();

        for (int[] p : points) {
            int y = p[1];
            countY.put(y, countY.getOrDefault(y, 0L) + 1);
        }

        // For each y-level, compute C(cnt, 2)
        List<Long> pairCounts = new ArrayList<>();

        for (long cnt : countY.values()) {
            if (cnt >= 2) {
                long pairs = cnt * (cnt - 1) / 2;
                pairCounts.add(pairs % MOD);
            }
        }

        // If less than 2 y-levels have at least 2 points → no trapezoid possible
        if (pairCounts.size() < 2) return 0;

        long sum = 0, sumSq = 0;

        for (long p : pairCounts) {
            sum = (sum + p) % MOD;
            sumSq = (sumSq + (p * p) % MOD) % MOD;
        }

        // Formula: sum_{i < j} (pi * pj) = (sum^2 - sumOfSquares) / 2
        long result = (sum * sum % MOD - sumSq + MOD) % MOD;

        // multiply by modular inverse of 2 → (MOD + 1) / 2 because MOD = 1e9+7
        result = result * ((MOD + 1) / 2) % MOD;

        return (int) result;
    }
}
