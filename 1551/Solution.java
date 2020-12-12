class Solution {
    public int minOperations(int n) {
        int ans = 0;
        int k = (n % 2 == 0)? (2 * (n/2)) : (2 * (n/2) + 1);
        for(int i = 0; i < n/2; i++){
            ans += (k - (2*i+1));
        }
        return ans;
    }
}