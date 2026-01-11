class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())return result;
        int freqP[] = new int[26];
        int window[] = new int[26];

        for(char c: p.toCharArray()){
            freqP[c-'a']++;
        }
        int left = 0;
        for(int right = 0;right <s.length();right++){
            window[s.charAt(right)-'a']++;

            if(right-left+1>p.length()){
                window[s.charAt(left)- 'a']--;
                left++;
            }
            if(right-left+1 == p.length()){
                if(Arrays.equals(freqP,window)){
                    result.add(left);
                }
                

            }
        }
        return result;
    }
} 

/*   public List<Integer> findAnagrams(String s, String p) {
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
} */