class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String>set = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                sb.append(morse[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}