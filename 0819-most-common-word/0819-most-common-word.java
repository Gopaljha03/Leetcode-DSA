class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String>bannedSet = new HashSet<>();
        for(String word : banned){
            bannedSet.add(word.toLowerCase());
        }
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words){
            if(word.isEmpty() || bannedSet.contains(word))continue;
            freqMap.put(word , freqMap.getOrDefault(word , 0) + 1);
        }
        String result = "";
        int maxcount = 0;

        for(Map.Entry<String , Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > maxcount){
                maxcount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}