class Solution {
    public int minSteps(String s, String t) {
        int[] ar1 = new int[26];
        int[] ar2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            ar1[s.charAt(i) - 'a']++;
            ar2[t.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < ar1.length; i++){
            if(ar2[i] > ar1[i])ans += (ar2[i] - ar1[i]);
        }
        return ans;
    }
}