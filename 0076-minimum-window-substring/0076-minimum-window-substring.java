class Solution {
    public String minWindow(String s, String t) { 
        
        int[]need = new int[128];
        for(char c :t.toCharArray()){
            need[c]++;
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int missing = t.length();

        for(int right = 0; right<s.length();right++){
            char c =  s.charAt(right);
            if(need[c]>0){
                missing--;
            }
            need[c]--;

            while(missing==0){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char leftchar = s.charAt(left);
                need[leftchar]++;
                if(need[leftchar]>0){
                    missing++;
                }
                left++;

            }
            
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
        