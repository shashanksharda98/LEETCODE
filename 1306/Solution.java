class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr.length == 0) return false;
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(start);
        hs.add(start);
        while(q.size() != 0){
            int cr = q.remove();
            if(arr[cr] == 0) return true;
            if(cr - arr[cr] >= 0 && !hs.contains(cr-arr[cr])){
                q.add(cr - arr[cr]);
                hs.add(cr - arr[cr]);
            }
            if(cr + arr[cr] < arr.length && !hs.contains(cr+arr[cr])){
                q.add(cr + arr[cr]);
                hs.add(cr + arr[cr]);
            }
        }
        return false;
    }
}