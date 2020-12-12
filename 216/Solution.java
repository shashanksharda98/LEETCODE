class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return solution(k, n, 1);
    }
    
    public List<List<Integer>> solution(int k, int n, int strt){
        if(k == 0){
            if(n == 0){
                List<List<Integer>> ret = new ArrayList<>();
                List<Integer> t = new LinkedList<>();
                ret.add(t);
                return ret;
            }
            return null;
        }
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = strt; i <= 9; i++){
            List<List<Integer>> rcvd = solution(k-1, n-i, i+1);
            if(rcvd != null){
                for(List<Integer> r : rcvd){
                    r.add(0, i);
                    temp.add(r);
                }
            }
        }
        return temp;
    }
}