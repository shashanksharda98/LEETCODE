class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> asof = new LinkedList<>();
        combinationHelper(ans, asof, candidates, 0, target);
        return ans;
    }
    
    public void combinationHelper(List<List<Integer>> ans, List<Integer> asof, int[] candidates, int idx,  int target){
        if(target <= 0 || idx >= candidates.length){
            if(target == 0){
                List<Integer> temp = new LinkedList<>(asof);
                ans.add(temp);
            }
            return;
        }
        int prev = -1;
        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] == prev) continue;
            asof.add(candidates[i]);
            combinationHelper(ans, asof, candidates, i+1, target - candidates[i]);
            asof.remove(asof.size() -1);
            prev = candidates[i];
        }
        return;
    }
}