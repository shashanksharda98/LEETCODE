class Solution {
    public String addBinary(String a, String b) {
//         int i = a.length() - 1, j = b.length() - 1;
//         String ans = "";
//         int carry = 0;
//         while(i >= 0 || j >= 0){
//             char f = i >= 0 ? a.charAt(i) : '0';
//             char s = j >= 0 ? b.charAt(j) : '0';
            
//             int x = f == '0' ? 0 : 1;
//             int y = s == '0' ? 0 : 1;
//             int z = 0;
//             if(carry == 0){
//                 z = (x ^ y);
//                 carry = (x & y);
//             }else{
//                 int t = (x ^ y);
//                 z = (t ^ carry);
//                 carry = (x | y);
//             }
//             ans = "" + z + ans;
//             i--;
//             j--;
//         }
//         return carry == 1 ? '1' + ans : ans;
        int i = a.length() - 1, j = b.length() - 1;
        String ans = "";
        int carry = 0;
        while(i >= 0 || j >= 0){
            int x = (i >= 0 && a.charAt(i--) == '1') ? 1 : 0;
            int y = (j >= 0 && b.charAt(j--) == '1') ? 1 : 0;
            ans = "" + (x ^ y ^ carry) + ans;
            carry = ((x&y) | (y&carry) | (x&carry));
        }
        return carry == 1 ? "1" + ans : ans;
    }
}