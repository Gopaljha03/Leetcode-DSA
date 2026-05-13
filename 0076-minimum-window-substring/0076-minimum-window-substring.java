class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer>map = new HashMap<>();
        
       
        
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int count = t.length();
        int left= 0;
        int minlen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right <s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)> 0){
                    count--;
                }
                map.put(ch,map.get(ch)-1);
            }
            
            while(count == 0){
                int currlen = right -left +1;
                if(currlen < minlen){
                    minlen = currlen;
                    start = left;
                }

                char leftchar  =s.charAt(left);
                if(map.containsKey(leftchar)){
                    map.put(leftchar, map.get(leftchar)+1);
                    if(map.get(leftchar)>0){
                        count++;
                       
                    }
                }
                left++;
                
                 
                
            }
        }
        if(minlen == Integer.MAX_VALUE)return "";
        return s.substring(start, start + minlen);
        
            
    }
}