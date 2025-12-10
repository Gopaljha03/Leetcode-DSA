class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            int start = i;

            // IMPORTANT FIX: i+1 < n instead of i < n
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }

            int end = i;

            if (end - start + 1 >= 3) {
                result.add(Arrays.asList(start, end));
            }

            i++; // move to the next group
        }

        return result;
    }
}
