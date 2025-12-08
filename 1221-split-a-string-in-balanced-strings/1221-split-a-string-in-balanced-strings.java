class Solution {
    public int balancedStringSplit(String s) {
        char [] ch = s.toCharArray();
        int results = 0;
        int countL = 0;
        int countR = 0;
        for(int i = 0; i<s.length(); i++){
            if(ch[i] == 'L')countL++;
            if(ch[i] == 'R')countR++;

            if(countL == countR)results++;
        }
        return results;
    }
}