class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int [] result = new int[n];

        int lastseen = -10000;
        for(int i = 0; i<n;i++){
            if(s.charAt(i) == c){
                lastseen = i;
            }
            result[i] = i - lastseen;
        }
        lastseen = 10000;
        for(int i = n-1; i>=0;i--){
            if(s.charAt(i) == c){
                lastseen = i;
            }
            result[i] = Math.min(result[i] , lastseen - i);
        }
        return result;
    }
}