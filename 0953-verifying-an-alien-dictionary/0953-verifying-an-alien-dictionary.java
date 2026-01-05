class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int rank[] = new int[26];
        for(int i = 0; i<order.length();i++){
            rank[order.charAt(i)-'a'] = i;
        }
        for(int i = 0; i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int minLen = Math.min(word1.length(), word2.length());
            boolean differentfound = false;
            for(int j = 0; j< minLen;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(rank[c1 - 'a']< rank[c2-'a']){
                    differentfound = true;
                    break;
                }
                if(rank[c1-'a'] > rank[c2-'a']){
                    return false;
                }

            }
            if (!differentfound && word1.length() > word2.length()) {
                return false;
            }

            
            
           
        }
        return true;

    }
}