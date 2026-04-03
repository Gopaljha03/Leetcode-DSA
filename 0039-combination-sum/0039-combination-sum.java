class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        backtrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;

    }
    public void backtrack(int index, int[]arr, int target, List<Integer>current, List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(index == arr.length|| target < 0){
            return;
        }
        current.add(arr[index]);
        backtrack(index, arr, target-arr[index],current, ans);

        current.remove(current.size()-1);

        backtrack(index+1,arr,target,current,ans);
    }
}