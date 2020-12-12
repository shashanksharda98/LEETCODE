class Solution {
    public List<String> letterCasePermutation(String S) {
        if(S.length() == 0){
            List<String> r = new ArrayList<String>();
            r.add("");
            return r;
        }
        List<String> ret = letterCasePermutation(S.substring(1));
        List<String> ans = new ArrayList<String>();
        if(S.charAt(0) <= 57){
            char ch = S.charAt(0);
            for(String e: ret) ans.add("" + ch + e);
            return ans;
        }else{
            String a = ""+S.charAt(0);
            for(String e: ret) ans.add(a.toLowerCase() + e);
            for(String e: ret) ans.add(a.toUpperCase() + e);
        }
        return ans;
    }
}