class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return solution(nums, 0);
    }
    
    public List<List<Integer>> solution(int[] nums, int k){
        if(k == nums.length){
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> t = new LinkedList<>();
            ret.add(t);
            return ret;
        }
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> rcvd = solution(nums, k+1);
        for(List<Integer> r : rcvd){
            temp.add(r);
            List<Integer> c = new LinkedList<>(r);
            c.add(0, nums[k]);
            temp.add(c);
        }
        return temp;
    }
}