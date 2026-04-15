class Solution {
    static String expand(String s, int left, int right){
        while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);

    }
    public String longestPalindrome(String s){
        String ans = "";
        for(int i = 0; i < s.length();i++){
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);

            if(odd.length()> ans.length()){
                ans =odd;
            }
            if(even.length()>ans.length()){
                ans = even;
            }
        }
        return ans;

    }
    

}
/*class Solution {
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

}*/