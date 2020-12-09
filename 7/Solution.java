class Solution {
    public int reverse(int x) {
        //if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) return 0;
        int temp = x < 0 ? -x : x;
        boolean flag = x < 0 ? true : false;
        int ans = 0;
        while(temp != 0){
            if(ans != 0 && Integer.MAX_VALUE/ans < 10) return 0;
            ans = (ans * 10) + (temp % 10);
            temp /= 10;
        }
        
        return flag? -ans: ans;
    }
}