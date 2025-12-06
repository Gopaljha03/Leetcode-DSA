class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;

        while(i < n){
            while(i <n && arr[i] == ' ')i++;
            int start = i;

            while(i<n && arr[i] != ' ')i++;
            int end = i - 1;

            while(start < end){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }

        }
        return new String(arr);
    }
}