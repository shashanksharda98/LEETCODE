class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int v: nums){
            if(pq.size() < k) pq.add(v);
            else{
                if(v > pq.peek()){
                    pq.poll();
                    pq.add(v);
                }
            }
        }
        return pq.peek();
    }
}