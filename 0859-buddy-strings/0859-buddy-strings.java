class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)){
            for(int i = 0; i<s.length();i++){
                for(int j = i+1; j<s.length();j++){
                    if(s.charAt(i) == s.charAt(j) ){
                        return true;
                    }
                }
            }
            return false;
        }
        if(!s.equals(goal)){
            int first = -1;
            int second = -1;
            for(int i = 0; i<s.length();i++){
                if(s.charAt(i) != goal.charAt(i)){
                    if(first == -1){
                        first = i;
                    }else if(second == -1){
                        second = i;
                    }else{
                        return false;
                    }
                }
            }
            if(second != -1 
            && s.charAt(first) == goal.charAt(second)
            && s.charAt(second) == goal.charAt(first)){
                return true;
            }else{
                return false;
            }
        }
        return true;
        
    }
}