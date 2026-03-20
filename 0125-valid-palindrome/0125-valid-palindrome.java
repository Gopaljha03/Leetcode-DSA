class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: clean string
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        return check(s, 0);
    }

    private boolean check(String s, int i){
        int n = s.length();

        if(i >= n/2){
            return true;
        }

        if(s.charAt(i) != s.charAt(n-i-1)){
            return false;
        }

        return check(s, i+1);
    }
}