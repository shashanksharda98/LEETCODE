class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 && carry != 0; i--){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if(carry == 1){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            for(int i = 1; i < ans.length; i++) ans[i] = digits[i-1];
            return ans;
        }
        
        return digits;
    }
}