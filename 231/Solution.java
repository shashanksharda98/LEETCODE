class Solution {
    public boolean isPowerOfTwo(int n) {
        int x = 0x80000000;
        if((x & n) != 0 || n == 0) return false;
        return ((n & (n-1)) == 0);
    }
}