class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max = 0, idx = 0, tot = 0;
        for(int i = nums.size() - 1; i >= 0; i--){
            for(int j = nums.get(i).size() - 1; j >= 0; j--){
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                    map.get(i+j).add(nums.get(i).get(j));
                }else{
                    map.get(i+j).add(nums.get(i).get(j));
                }
                if(i+j > max) max = i+j;
                tot++;
            }
        }
        //ArrayList<Integer> ans = new ArrayList<>();
        int[] ans = new int[tot];
        for(int diag = 0; diag <= max; diag++){
            for(Integer n : map.get(diag)) ans[idx++] = n;
        }
        //int[] arr = new int[ans.size()];
        //arr = ans.toArray(arr);
        return ans;
    }
}