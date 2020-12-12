class Solution {
    public int rob(int[] nums) {
        int consider = 0, notconsider = 0;
        for(int i = 0; i < nums.length; i++){
            int tempc = nums[i] + notconsider;
            int tempnc = Math.max(consider, notconsider);
            
            consider = tempc;
            notconsider = tempnc;
        }
        return Math.max(consider, notconsider);
    }
}