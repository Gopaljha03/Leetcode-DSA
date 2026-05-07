class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character , Integer> map = new HashMap<>();
        int k = s1.length();
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int i =0 ;
        for(int j = 0; j < s2.length();j++){
            char incoming = s2.charAt(j);
            if(map.containsKey(incoming)){
                map.put(incoming , map.get(incoming)-1);
                if(map.get(incoming)== 0){
                    count--;
                }
            }
            if(j -i+1 == k){
                if(count == 0){
                    return true;
                }
                char outgoing = s2.charAt(i);
                if(map.containsKey(outgoing)){
                    if(map.get(outgoing)== 0){
                        count++;
                    }
                    map.put(outgoing, map.get(outgoing)+1);
                }
                i++;
            }
        }
        return false;
        
    }
}