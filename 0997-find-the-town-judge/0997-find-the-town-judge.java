class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer>intrust = new HashMap<>();
        HashMap<Integer, Integer>outtrust = new HashMap<>();

        for(int[]t: trust){
            int a  = t[0];
            int b = t[1];

            outtrust.put(a, outtrust.getOrDefault(a,0)+1);
            intrust.put(b, intrust.getOrDefault(b,0)+1);

        }
        for(int i = 1;i<=n;i++){
            int trustedby = intrust.getOrDefault(i,0);
            int trusts = outtrust.getOrDefault(i,0);

            if(trustedby == n-1 && trusts==0){
                return i;
            }

        }
        return -1;
    }
}