class Solution {
    public int numOfSubarrays(int[] arr) {
        int M = 1000000007;
        int n = arr.length;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1; i<=n; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int count = 0;
        int evenCount = 1;
        int oddCount = 0;
        for(int i = 1; i<=n; i++){
            if(prefix[i]% 2==0){ // odd+ even = odd
              count = (count + oddCount) % M;
              evenCount++; 
            } else{ // even + odd = odd;
              count = (count + evenCount) % M;
              oddCount++;
            }
        }
        return count;
        
    }
}