class Solution {
    public int maxLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            long prod = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {

                prod *= nums[j];

                gcd = findGCD(gcd, nums[j]);

                lcm = (lcm / findGCD(lcm, nums[j])) * nums[j];

                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public long findGCD(long a, long b) {

        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }
}