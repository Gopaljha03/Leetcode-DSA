class Solution {
    public boolean checkRecord(String s) {
        int absentcount = 0;
        int latecount = 0;

        for(char c : s.toCharArray()){
            if(c == 'A') absentcount++;
            if(absentcount > 1)return false;

            if(c == 'L'){
                latecount++;
                if(latecount >= 3)return false;
            }else{
                latecount = 0;
            }
        }
        return true;
    }
}