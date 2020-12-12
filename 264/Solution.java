class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 6) return n;
        int[] prime = {2, 3, 5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        for(int i = 1; i < n; i++){
            long temp = pq.remove();
            for(int p: prime){
                if(!pq.contains(temp * p)) pq.add(p * temp);
            }
        }
        return pq.remove().intValue();
    }
}