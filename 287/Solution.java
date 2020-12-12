class Solution {
    public int findDuplicate(int[] nums) {
        //floyd cycle detection
        //similar approach
        //think of the integer values in the nums as nodes of a linked list
        int a = 0, b = 0;
        while(true){
            a = nums[a];
            b = nums[nums[b]];
            if(a == b){
                a = 0;
                while(true){
                    if(a == b) return a;
                    a = nums[a];
                    b = nums[b];
                }
            }
        }
        
    }
}