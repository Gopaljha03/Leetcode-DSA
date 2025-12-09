class Solution {
    public int[] numberOfLines(int[] widths, String s) {
       
        char[] ch = s.toCharArray();
        
        int lines = 1;
        int currwidth =0;
        
        for(int i = 0; i<s.length();i++){
            int index = ch[i] - 'a';
            int letterwidth = widths[index];

            if(currwidth + letterwidth > 100){
                lines++;
                currwidth = letterwidth;
            }else{
                currwidth += letterwidth;
            }
           
        }
        return new int[]{lines, currwidth};
    }
}