class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int a = 0;
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        for(;i < k; i++){
            while(dq.size() != 0 && nums[dq.peekLast()] < nums[i]) dq.removeLast();
            
            dq.addLast(i);
        }
        
        for(;i < nums.length; i++){
            ans[a++] = nums[dq.peekFirst()];
            
            while(dq.size() != 0 && dq.peekFirst() <= i-k) dq.removeFirst();
            
            while(dq.size() != 0 && nums[dq.peekLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        ans[a] = nums[dq.peekFirst()];
        return ans;
    }
}