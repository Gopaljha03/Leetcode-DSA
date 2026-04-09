class Solution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>>ans = new ArrayList<>();
        backtrack(0, nums,ans);
        return ans;

    }
    private void backtrack(int index, int nums[], List<List<Integer>>ans){
        if(index == nums.length){
            List<Integer>temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            ans.add(temp);
            return ;
        }
        for(int i = index; i<nums.length;i++){
            swap(nums, index,i);
            backtrack(index+1, nums,ans);
            swap(nums, index,i);
        }
    }
    private void swap(int[]nums, int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}
/*class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        HashMap<Integer,Boolean>map = new HashMap<>();
        for(int num : nums){
            map.put(num ,false);
        }
        backtrack(nums,map, new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int[] nums, HashMap<Integer, Boolean>map, List<Integer>curr, List<List<Integer>>ans){
        if(curr.size()== nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int num : nums){
            if(map.get(num))continue;
            map.put(num, true);
            curr.add(num);
            backtrack(nums,map, curr, ans);
            curr.remove(curr.size()-1);
            map.put(num, false);

        }
    }
}*/