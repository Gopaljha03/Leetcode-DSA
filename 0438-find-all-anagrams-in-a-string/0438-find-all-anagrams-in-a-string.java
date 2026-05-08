class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result =  new ArrayList<>();
        if(s.length()<p.length())return result;
        HashMap<Character, Integer>map = new HashMap<>();
        for(char c :p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count =  map.size();
        int i = 0, j = 0;
        int k = p.length();

        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)== 0){
                    count--;
                }
            }
            if(j-i+1<k){
                j++;
            }else if(j - i +1 == k){
                if(count  == 0){
                    result.add(i);
                }
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)== 1)count++;
                }
                
                i++;
                j++;
            }
        }
        return result;
    }
}