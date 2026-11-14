class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int result = Integer.MAX_VALUE;
        for(int i = 0; i< n; i++){
            int sum = 0;
            for(int j =i; j< n && (j-i+1)<=r; j++){
            sum+= nums.get(j);
             if((j-i+1 >=l) && sum>0){
             result = Math.min(result, sum);
             }
            }
        }
       if(result == Integer.MAX_VALUE){
        return -1;
       }
       return result;
    }
}