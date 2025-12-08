class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        boolean [] allowedchars = new  boolean[26];
        char [] allowedArray = allowed.toCharArray();
        
        for(int i = 0; i<allowed.length(); i++){
            allowedchars[allowedArray[i]- 'a'] = true;;
        }
        int count = 0;
        for(String word : words){
            boolean isConsistence = true;
            for(char c : word.toCharArray()){
                if(!allowedchars[c- 'a']){
                    isConsistence = false;
                    break;
                }
            }
            if(isConsistence)count++;
            

        }
        return count++;
        
    }
}