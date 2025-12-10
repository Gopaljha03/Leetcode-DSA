class Solution {
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split(" ");
        StringBuilder result =  new StringBuilder();
        for(int i = 0; i<words.length;i++){
            String word =words[i];
            StringBuilder sb = new StringBuilder();
            char first = word.charAt(0);
            if(vowels.indexOf(first) != -1){
                sb.append(word).append("ma");
            }else{
                sb.append(word.substring(1))
                .append(first)
                .append("ma");
            }
            for(int j = 0; j<=i; j++){
                sb.append('a');
            }
            result.append(sb).append(" ");
        }
        return result.toString().trim();
    }
}