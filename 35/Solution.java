class Solution {
    public int searchInsert(int[] nums, int target) {
        int strt = 0, end = nums.length-1;
        while(strt <= end){
            int mid = (strt + end)/2;
            if(nums[mid] < target){
                strt = mid + 1;
            }else if(nums[mid] > target){
                end = mid -1;
            }else return mid;
        }
        return strt;
    }
}