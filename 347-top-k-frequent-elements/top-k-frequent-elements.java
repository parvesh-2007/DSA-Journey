class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);

            } else{
                map.put(nums[i], 1);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        

        for(int num: map.keySet()){
            pq.add(new int[]{map.get(num), num});

            if(pq.size()>k){
            pq.remove();
        }
        }

        int[] ans = new int[k];
        for(int i = 0; i<k ; i++){
            ans[i] = pq.remove()[1];
        }
        return ans;







        
    }
}