class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2001];
        for(int v: arr){
            if(v < 0){
                map[2001 + v]++;
            }else map[v]++; 
        }
        HashSet<Integer> set = new HashSet<>();
        for(int c: map){
            if(c != 0){
                if(!set.contains(c)) set.add(c);
                else return false;
            }
        }
        return true;
        
        
        
        
        
        
        
        
        
        
        
        
        
        //approach using hashmap and hashset faster than 99.43%
        // HashSet<Integer> set = new HashSet<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int v: arr){
        //     if(!map.containsKey(v)) map.put(v, 1);
        //     else map.put(v, map.get(v) + 1);
        // }
        // for(Integer i: map.keySet()){
        //     int cr = map.get(i);
        //     if(!set.contains(cr)) set.add(cr);
        //     else return false;
        // }
        // return true;
    }
}