class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums1.length; i++){
            set.add(nums1[i]);
        }
        int[] temp = new int[nums2.length];
        int count = 0;
        for(int i = 0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                temp[count] = nums2[i];
                count++;
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[count];

        for (int i = 0; i < count; i++) {
            ans[i] = temp[i];
        }

        return ans;
        
    }
}