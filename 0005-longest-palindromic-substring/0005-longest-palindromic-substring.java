class Solution {
    static boolean ispalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i =0; i < n;i++){
            for(int j  =i; j<n;j++){
                if(ispalindrome(s,i,j)){
                    if(j-i+1 > ans.length()){
                        ans = s.substring(i, j+1);
                    }
                }

            }
        }
        return ans;
    }

}