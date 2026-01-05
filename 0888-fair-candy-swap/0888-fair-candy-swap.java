class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice =0;
        int sumBob = 0;
        for(int a : aliceSizes)sumAlice +=a;
        for(int b : bobSizes)sumBob +=b;
        
        int diff=(sumBob - sumAlice)/2;
        HashSet<Integer>set = new HashSet<>();
        for(int b :bobSizes){
            set.add(b);

        }
        for(int a : aliceSizes){
            int needFromBob = a+diff;
            if(set.contains(needFromBob)){
                return new int[]{a, needFromBob};
            }
        }
        return new  int[0];

    }
}