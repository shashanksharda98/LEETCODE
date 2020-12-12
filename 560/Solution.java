class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0;
        for(int v: nums){
            prefixsum += v;
            int temp = prefixsum - k;
            if(map.containsKey(temp)) ans+=map.get(temp);
            if(map.containsKey(prefixsum)) map.put(prefixsum, map.get(prefixsum)+1);
            else map.put(prefixsum, 1);
        }
        return ans;
    }
}