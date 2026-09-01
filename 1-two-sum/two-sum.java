class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int requirr = target-nums[i];
            if(map.containsKey(requirr)){
                return new int[]{map.get(requirr), i};
            }
            map.put(nums[i], i);
        }
        return null;
        
    }
}