class Solution {
    public boolean checkIfPangram(String sentence) {
        char [] ch = sentence.toCharArray(); 
        boolean[] seen = new boolean[26];
        
       
       for(int i = 0;i<sentence.length();i++){
        char c = ch[i];
        int index = c - 'a';
        seen[index] = true;
        
       }

        for(boolean b : seen){
            if(!b) return false;
        }
        return true;
        
        

    }
}