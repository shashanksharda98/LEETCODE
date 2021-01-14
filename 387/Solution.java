class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int[] occurence = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
            occurence[ch-'a'] = occurence[ch-'a'] != 0 ? occurence[ch-'a']: i;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(arr[i] == 1){
                ans = Math.min(ans, occurence[i]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}