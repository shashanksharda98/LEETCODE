class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, i = 0, j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j < s.length()){
            char crr = s.charAt(j);
            if(!hm.containsKey(crr)){
                hm.put(crr, j);
                //ans = Math.max(ans, j-i+1);
            }else{
                i = hm.get(crr) +1 > i? hm.get(crr) + 1 : i;
                hm.put(crr, j);
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}