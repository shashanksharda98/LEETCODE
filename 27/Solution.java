class Solution {
    public int removeElement(int[] nums, int val) {
        int first = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[first] = nums[i];
                first++;
            }
        }
        return first;
    }
}