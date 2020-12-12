class Solution {
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, indx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                indx = i;
            }
            if(nums[i] > max2 && nums[i] < max1) max2 = nums[i];
        }
        if(max1 >= max2*2) return indx;
        return -1; 
    }
}