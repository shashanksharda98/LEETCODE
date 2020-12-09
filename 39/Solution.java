class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return comb(candidates, target, 0);
    }
    
    public List<List<Integer>> comb(int[] nums, int target, int st){
        if(target <= 0){
            if(target == 0){
                List<List<Integer>> ret = new LinkedList<>();
                List<Integer> a = new LinkedList<>();
                ret.add(a);
                return ret;
            }
            return  null;
        }
        List<List<Integer>> temp = new LinkedList<>();
        for(int i = st; i < nums.length; i++){
            List<List<Integer>> rcvd = comb(nums, target - nums[i], i);
            if(rcvd != null){
                for(List<Integer> c : rcvd){
                    c.add(0, nums[i]);
                    temp.add(c);
                }
            }
        }
        return temp;
    }
}