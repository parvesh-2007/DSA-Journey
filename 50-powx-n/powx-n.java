class Solution {
    public double myPow(double x, int n) {
        return power(x, (long)n);
        
    }
    double power(double x, long n){
        // base 
        if(n<0){
            return 1/power(x, -n);
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        // rec 
        double half = power(x, n/2);
        if(n % 2==0){
            return half * half;
        }
        return x * half * half;

        
    }
}   