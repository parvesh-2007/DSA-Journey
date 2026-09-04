class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        // Array ke saare elements Set mein daalo
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        // Set ke elements traverse karo
        for (int x : set) {

            // Agar x-1 present nahi hai,
            // toh x ek sequence ka starting point hai
            if (!set.contains(x - 1)) {

                int count = 1;
                int current = x;

                // x+1, x+2, x+3... check karo
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}