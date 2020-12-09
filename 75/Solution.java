class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, a = 0;
        while(a < nums.length && a <= j){
            if(nums[a] == 0){
                int temp = nums[a];
                nums[a] = nums[i];
                nums[i] = temp;
                i++;
                a++;
            }else if(nums[a] == 2){
                int temp = nums[a];
                nums[a] = nums[j];
                nums[j] = temp;
                j--;
            }else a++;
        }
        
    }
}