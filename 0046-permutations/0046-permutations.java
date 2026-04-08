class Solution {
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
}