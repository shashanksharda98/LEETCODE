class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int hi = nums.length -1, low = 0;
        // lower index OR finding first occurence
        while(low <= hi){
            int mid = (low+hi)/2;
            if(nums[mid] > target){
                hi = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                ans[0] = mid;
                hi = mid-1;
            }
        }
        
        //***************************************
        
        low = 0;
        hi = nums.length -1;
        
        while(low <= hi){
            int mid = (low+hi)/2;
            if(nums[mid] > target){
                hi = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                ans[1] = mid;
                low = mid+1;
            }
        }
        
        
        return ans;
    }
}