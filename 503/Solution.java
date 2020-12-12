class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(stack.size() == 0) stack.push(i);
            else{
                while(stack.size() != 0 && nums[stack.peek()] < nums[i]){
                    ans[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            while(stack.size() != 0 && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }
        }
        while(stack.size() != 0) ans[stack.pop()] = -1;
        
        return ans;
    }
}