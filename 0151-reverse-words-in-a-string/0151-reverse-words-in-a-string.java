//TIME COMPLEXITY O(n) && SPACE O(1)
class Solution {
    public String reverseWords(String s) {
      char[] arr = s.toCharArray();
      int n = arr.length;
      reverse(arr, 0 , n-1);

      int start = 0;
      for(int end = 0; end<=n;end++){
        if(end == n || arr[end] == ' '){
            reverse(arr, start, end -1);
            start = end+1;
        }
      }
      int i = 0, j=0;
      while(j < n){
        while(j < n && arr[j] == ' ')j++;
        while(j < n && arr[j] != ' ')arr[i++] = arr[j++];
        while(j<n && arr[j] ==' ')j++;
        if(j < n)arr[i++] = ' ';
      }
      return new String(arr, 0, i);
    }
    public  void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
//TIME COMPLEXITY O(n) && SPACE O(n)
/*
class Solution {
    public String reverseWords(String s) {
      String [] words = s.trim().split("\\s+");
      StringBuilder sb = new StringBuilder();
      for(int i = words.length-1; i>=0;i--){
        sb.append(words[i]);
        if(i > 0){
            sb.append(" ");
        }

      }
      return sb.toString();
    }
}*/