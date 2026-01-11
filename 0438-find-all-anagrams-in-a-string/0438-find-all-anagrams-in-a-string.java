class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int [] freqP  = new int[26];
        for(char c : p.toCharArray()){
            freqP[c - 'a']++;
        }
        for(int i =0; i<=s.length()-p.length();i++){
            int [] freq = new int[26];

            for(int j = i; j<i+p.length();j++){
                freq[s.charAt(j) - 'a']++;
            }
            if(Arrays.equals(freqP,freq)){
                result.add(i);
            }
        }
        return result;
    }
} 