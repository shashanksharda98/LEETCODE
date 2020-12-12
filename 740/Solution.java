class Solution {
    public int deleteAndEarn(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int v: nums){
            if(!map.containsKey(v)){
                map.put(v, 1);
            }else map.put(v, map.get(v)+1);
            
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        int inc = 0, ex = 0;
        for(int i = min; i <= max; i++){
            if(map.containsKey(i)){
                int new_inc = map.containsKey(i-1) ? ex + (i * map.get(i)) : Math.max(inc, ex) + i * map.get(i);
                int new_ex = Math.max(inc, ex);
                inc = new_inc;
                ex = new_ex;
            }
        }
        return Math.max(inc, ex);
    }
}