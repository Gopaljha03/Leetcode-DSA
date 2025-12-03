import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        
        Map<String, Map<Long, Integer>> slopeMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                String key = dx + "," + dy;
                long intercept = (long)points[i][0] * dy - (long)points[i][1] * dx;
                slopeMap.computeIfAbsent(key, k -> new HashMap<>())
                        .merge(intercept, 1, Integer::sum);
            }
        }
        
        long totalCandidates = 0;
        for (Map<Long, Integer> intercepts : slopeMap.values()) {
            long sum = 0;
            long sumSq = 0;
            for (int count : intercepts.values()) {
                sum += count;
                sumSq += (long)count * count;
            }
            totalCandidates += (sum * sum - sumSq) / 2;
        }
        
        Map<String, List<int[]>> midMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sx = points[i][0] + points[j][0];
                long sy = points[i][1] + points[j][1];
                midMap.computeIfAbsent(sx + "," + sy, k -> new ArrayList<>())
                      .add(new int[]{i, j});
            }
        }
        
        long parallelograms = 0;
        for (List<int[]> pairs : midMap.values()) {
            int sz = pairs.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    int[] a = pairs.get(i);
                    int[] b = pairs.get(j);
                    
                    long dx1 = points[a[1]][0] - points[a[0]][0];
                    long dy1 = points[a[1]][1] - points[a[0]][1];
                    long dx2 = points[b[0]][0] - points[a[0]][0];
                    long dy2 = points[b[0]][1] - points[a[0]][1];
                    
                    if (dx1 * dy2 - dy1 * dx2 != 0) {
                        parallelograms++;
                    }
                }
            }
        }
        
        return (int) (totalCandidates - parallelograms);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}


