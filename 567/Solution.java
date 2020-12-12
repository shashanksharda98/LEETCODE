class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch, 1);
            }else{
                hm.put(ch, hm.get(ch) + 1);
            }
        }
        int len = 0, a = 0;
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(!hm.containsKey(ch)){
                for(int j = a; j < i; j++) hm.put(s2.charAt(j), hm.get(s2.charAt(j)) +1);
                a = i+1;
                len = 0;
            }else if(hm.get(ch) > 0){
                len++;
                hm.put(ch, hm.get(ch) - 1);
                if(len == s1.length()) return true;
            }else if(hm.get(ch) == 0){
                while(hm.get(ch) == 0 && a < i){
                    len--;
                    hm.put(s2.charAt(a), hm.get(s2.charAt(a)) + 1);
                    a++;
                }
                i--;
            }
        }
        return false;
    }
}