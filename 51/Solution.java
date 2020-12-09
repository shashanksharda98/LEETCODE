class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> asf = new ArrayList<>();
        String s = "";
        for(int i = 0; i < n; i++) s += ".";
        helper(n, 0, 0, 0, ans, asf, s);
        return ans;
    }
    
    public void helper(int n, int col, int d1, int d2, List<List<String>> ans, List<String> asf, String s){
        if(asf.size() == n){
            List<String> t = new LinkedList<>(asf);
            ans.add(t);
            return;
        }
        int r = asf.size() + 1;
        for(int i = 0; i < s.length(); i++){
            int mask_col = (1 << i);
            int mask_d1 = (1 << (n - (i - r)));
            int mask_d2 = (1 << (i+r));
            if((mask_col & col) != mask_col && (d1 & mask_d1) != mask_d1 && (d2 & mask_d2) != mask_d2){
                String temp = s.substring(0, i) + "Q" + s.substring(i+1);
                col ^= mask_col;
                d1 ^= mask_d1;
                d2 ^= mask_d2;
                asf.add(temp);
                helper(n, col, d1, d2, ans, asf, s);
                asf.remove(asf.size()-1);
                col ^= mask_col;
                d1 ^= mask_d1;
                d2 ^= mask_d2;
            }
        }
    }
}