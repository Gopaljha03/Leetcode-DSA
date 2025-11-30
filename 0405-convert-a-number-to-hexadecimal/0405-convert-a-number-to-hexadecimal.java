class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        long n = num;
        if(n<0){
            n = n+ (1L << 32);
        }
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder sb = new StringBuilder();

        while(n>0){
            int remainder = (int)(n%16);
            sb.append(hex[remainder]);
            n= n/16;
        }
        return sb.reverse().toString();
    }
}