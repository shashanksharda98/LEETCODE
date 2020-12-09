class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans  = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            ans.add(1);
            for(int j = ans.size() - 2; j >= 1; j--){
                int update = ans.get(j)+ans.get(j-1);
                ans.set(j,update);
            } 
        }
        return ans;
    }
}