import java.util.HashMap;
import java.util.Map;

class Solution {
    // Map to store Roman numeral values
    private static final Map<Character, Integer> romanMap = new HashMap<>();
    
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int total = 0;        
        int prevValue = 0;   
        
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            if (currentValue < prevValue) {
                
                total -= currentValue;
            } else {
               
                total += currentValue;
            }
           
            prevValue = currentValue;
        }
        
        return total;
    }

   
    
}
