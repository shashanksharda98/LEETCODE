class Solution {
    public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<>();
//         HashSet<Integer> chck = new HashSet<>();
//         List<Integer> asf = new ArrayList<>();
        
//         for(int i = 1; i <= n; i++){
//             chck.add(i);
//             asf.add(i);
//             comb(ans, i+1, n, k-1, chck, asf);
//             asf.remove(asf.size() - 1);
//         }
//         return ans;
        if(k == 0){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> t = new ArrayList<>();
            ans.add(t);
            return ans;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = n; i >= 1; i--){
            List<List<Integer>> temp = combine(i-1, k-1);
            for(List<Integer> c: temp){
                c.add(i);
                ret.add(c);
            }
        }
        return ret;
    }
    
    // public void comb(List<List<Integer>> ans, int a, int n, int k, HashSet<Integer> used, List<Integer> asf){
    //     if(k == 0){
    //         List<Integer> temp = new ArrayList<>(asf);
    //         ans.add(temp);
    //         return;
    //     }
    //     for(int i = a; i <= n; i++){
    //         if(!used.contains(i)){
    //             used.add(i);
    //             asf.add(i);
    //             comb(ans, i+1, n, k-1, used, asf);
    //             asf.remove(asf.size() - 1);
    //             used.remove(i);
    //         }
    //     }
    // }
}