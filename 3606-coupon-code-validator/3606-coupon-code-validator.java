import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> valid = new ArrayList<>();
        // Define the allowed business line order
        List<String> order = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        
        // Map to group codes by business line
        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) map.put(b, new ArrayList<>());
        
        for (int i = 0; i < code.length; i++) {
            String c = code[i];
            String bLine = businessLine[i];
            
            // 1. Active check
            if (!isActive[i]) continue;
            
            // 2. Non-empty check
            if (c == null || c.length() == 0) continue;
            
            // 3. Valid business line
            if (!map.containsKey(bLine)) continue;
            
            // 4. Check code characters (letters, digits, or '_')
            boolean validChars = true;
            for (char ch : c.toCharArray()) {
                if (!Character.isLetterOrDigit(ch) && ch != '_') {
                    validChars = false;
                    break;
                }
            }
            if (!validChars) continue;
            
            // Add to corresponding business line group
            map.get(bLine).add(c);
        }
        
        // Build final sorted list
        List<String> result = new ArrayList<>();
        for (String b : order) {
            List<String> codes = map.get(b);
            Collections.sort(codes); // sort lexicographically within business line
            result.addAll(codes);
        }
        
        return result;
    }
}
