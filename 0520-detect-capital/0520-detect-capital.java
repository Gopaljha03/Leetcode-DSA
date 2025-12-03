class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toUpperCase())) return true;
        if(word.equals(word.toLowerCase())) return true;

        if(Character.isUpperCase(word.charAt(0))){
            String rest =  word.substring(1);
            if(rest.equals(rest.toLowerCase())) return true;
        }
        return false;
    }
    
}