class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(ans, nums, new HashSet<Integer>(), new ArrayList<Integer>());
        return ans;
    }
    
    public void perm(List<List<Integer>> ans, int[] nums, HashSet<Integer> mp, List<Integer> asf){
        if(mp.size() == nums.length){
            
                List<Integer> temp = new ArrayList<Integer>(asf);
                ans.add(temp);
                //chck.add(sf);
            
            return;
        }
        HashSet<Integer> cr_pos = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!mp.contains(i) && !cr_pos.contains(nums[i])){
                cr_pos.add(nums[i]);
                mp.add(i);
                asf.add(nums[i]);
                perm(ans, nums, mp, asf);
                asf.remove(asf.size() - 1);
                mp.remove(i);
            }
        }
    }
}