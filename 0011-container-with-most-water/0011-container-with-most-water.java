class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxArea = 0;
        while(left < right){
            int width =(right - left);
            int waterheight = Math.min(height[left] , height[right]);
            int Area = width * waterheight;
            maxArea = Math.max(Area, maxArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        return maxArea;

    }
}