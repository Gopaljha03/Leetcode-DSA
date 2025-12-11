import java.util.*;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int[] b : buildings) {
            int r = b[0], c = b[1];
            rowMap.computeIfAbsent(r, k -> new ArrayList<>()).add(c);
            colMap.computeIfAbsent(c, k -> new ArrayList<>()).add(r);
        }
        
        for (List<Integer> lst : rowMap.values()) Collections.sort(lst);
        for (List<Integer> lst : colMap.values()) Collections.sort(lst);

        int covered = 0;
        for (int[] b : buildings) {
            int r = b[0], c = b[1];

            List<Integer> rowCols = rowMap.get(r);
            List<Integer> colRows = colMap.get(c);

            
            boolean rowLeft = existsSmaller(rowCols, c);
            boolean rowRight = existsLarger(rowCols, c);
            if (!rowLeft || !rowRight) continue;

            
            boolean colUp = existsSmaller(colRows, r);
            boolean colDown = existsLarger(colRows, r);
            if (colUp && colDown) covered++;
        }
        return covered;
    }

    
    private boolean existsSmaller(List<Integer> sorted, int key) {
        
        int idx = Collections.binarySearch(sorted, key);
        if (idx < 0) idx = -idx - 1;
        return idx - 1 >= 0;
    }

   
    private boolean existsLarger(List<Integer> sorted, int key) {
        int idx = Collections.binarySearch(sorted, key);
        if (idx < 0) idx = -idx - 1;
        else idx = idx + 1; 
        return idx < sorted.size();
    }

   
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        int[][] buildings = {{0,0},{0,4},{4,0},{4,4},{2,2},{0,2},{2,0},{2,4},{4,2}};
        System.out.println(sol.countCoveredBuildings(n, buildings)); // expected: number of covered ones
    }
}
