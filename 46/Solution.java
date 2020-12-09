class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(ans, nums, new HashSet<Integer>(), new ArrayList<Integer>());
        return ans;
    }
    
    public void perm(List<List<Integer>> ans, int[] nums, HashSet<Integer> mp, List<Integer> asf){
        if(mp.size() == nums.length){
            List<Integer> temp = new ArrayList<Integer>(asf);
            ans.add(temp);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!mp.contains(i)){
                asf.add(nums[i]);
                mp.add(i);
                perm(ans, nums, mp, asf);
                mp.remove(i);
                asf.remove(asf.size() - 1);
            }
        }
        
    }
}