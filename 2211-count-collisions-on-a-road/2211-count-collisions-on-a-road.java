class Solution {
    public int countCollisions(String directions) {
        char[] cars = directions.toCharArray();
        int n = cars.length;

        int left = 0;
        while(left <n && cars[left] == 'L'){
            left++;
        }
        int right = n-1;
        while(right >=0 && cars[right]=='R'){
            right--;
        }
        int collision = 0;
        for(int i = left ; i<= right;i++){
            if(cars[i] == 'L' || cars[i] == 'R' ){
                collision++;
            }
        }
        return collision;
    }
}