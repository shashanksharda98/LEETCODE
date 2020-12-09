class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            int[] chr = new int[26];
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                chr[ch - 'a']++;
            }
            String key = "";
            for(int i = 0; i < chr.length; i++){
                key += chr[i] + " "; 
            }
            if(!hm.containsKey(key)){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                hm.put(key, temp);
            }else{
                hm.get(key).add(s);
            }
        }
        for(String li: hm.keySet()){
            ans.add(hm.get(li));
        }
        return ans;
        
    }
}