class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> need = new HashMap<>();
        for(char ch  : licensePlate.toLowerCase().toCharArray()){
            if(Character.isLetter(ch)){
                need.put(ch, need.getOrDefault(ch, 0)+ 1);
            }
        }
        String answer = "";
        for(String word : words){
            if(isValid(word, need)){
                if(answer.equals("")|| word.length() < answer.length()){
                    answer = word;
                }
            }
        }
        return answer;
    }
    private boolean isValid(String word , Map<Character, Integer>need){
        Map<Character, Integer> count = new HashMap<>();
        for(char ch : word.toLowerCase().toCharArray()){
            count.put( ch , count.getOrDefault(ch, 0)+ 1);
        }
        for(char key : need.keySet()){
            if(count.getOrDefault(key,0) < need.get(key)){
                return false;
            }
        }
        return true;
    }
}