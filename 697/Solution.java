class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }else map.get(nums[i]).add(i);
            
            degree = Math.max(degree, map.get(nums[i]).size());
        }
        int ans = Integer.MAX_VALUE;
        for(Integer n: map.keySet()){
            if(map.get(n).size() == degree){
                List<Integer> temp = map.get(n);
                ans = Math.min(ans, temp.get(temp.size()-1) - temp.get(0) + 1);
            }
        }
        return ans;
    }
}