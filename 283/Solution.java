class Solution {
    public void moveZeroes(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) n++;
            else nums[i-n] = nums[i];
        }
        for(int i = 0; i < n; i++) nums[nums.length - 1 - i] = 0;
    }
}