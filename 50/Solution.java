class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            //n *= -1;
            return 1/ (x * (myPow(x, (-1)*(n+1))));
        }
        if(n % 2 != 0) return x * myPow(x, n - 1);
        
        int power = n/2;
        double re_ans = myPow(x, power);
        return re_ans * re_ans;
    }
}