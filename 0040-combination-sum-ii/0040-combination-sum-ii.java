import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int index, int[]arr, int target,List<Integer>current, List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = index ; i < arr.length;i++){
            if(i > index && arr[i] == arr[i-1])continue;
            if(arr[i]>target)break;

            current.add(arr[i]);

            backtrack(i +1, arr,target-arr[i],current, ans);
            current.remove(current.size()-1);
        }
    }

   
}