class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length;i++){
            st.push(s[i]);
        }
        int i = 0;
        while(!st.isEmpty()){
            char c = st.peek();
            s[i] = st.pop();
            i++;
        }
        
    }
}
/*class Solution {
    public void reverseString(char[] s) {
        int left = 0; 
        int right = s.length -1;
        while(left<= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
        
    }
}*/