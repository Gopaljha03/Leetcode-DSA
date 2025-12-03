class Solution {
    public String[] findWords(String[] words) {
        String row1 ="qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> result = new ArrayList<>();
        for(String word:words){
            String lower = word.toLowerCase();

            if(row1.indexOf(lower.charAt(0)) != -1){
                if(belongToRow(lower,row1))result.add(word);
            }else if(row2.indexOf(lower.charAt(0)) != -1){
                if(belongToRow(lower,row2))result.add(word);
            }else if(row3.indexOf(lower.charAt(0))!= -1){
                if(belongToRow(lower,row3))result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
    private boolean belongToRow(String word, String row){
        for(char c: word.toCharArray()){
            if(row.indexOf(c) == -1){
                return false;
            }
            
        }
        return true;
    }
}