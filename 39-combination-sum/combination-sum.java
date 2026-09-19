class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        helper(candidates, 0, target, ans, new ArrayList<>());
        return ans;
        
    }
    public void helper(int[]arr, int idx, int target, List<List<Integer>> ans, List<Integer>combin){
        if(idx==arr.length || target <0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(combin));
            return;
        }
        combin.add(arr[idx]);
        // single
        // helper(arr, idx+1, target - arr[idx], ans, combin);
        //multiple
        helper(arr, idx, target- arr[idx], ans, combin);
        // exclusion
        combin.remove(combin.size()-1);
        helper(arr, idx+1, target, ans, combin);
    }
}