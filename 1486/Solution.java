class Solution {
    public int xorOperation(int n, int start) {
        //int[] nums = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int temp = start + (2*i);
            ans = (ans ^ temp);
        }
        return ans;
    }
}