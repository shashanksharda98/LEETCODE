class Solution {
    static List<List<Character>> key = new ArrayList<>();
    public void keyupdate(){
        key.add(new ArrayList<>());
        int chr = 97;
        for(int i = 2; i <= 9; i++){
            List<Character> temp = new ArrayList<>();
            if(i == 7 || i == 9){
                for(int j = 0; j < 4; j++){
                    temp.add((char) chr);
                    chr++;
                }
            }else{
                for(int j = 0; j < 3; j++){
                    temp.add((char) chr);
                    chr++;
                }
            }
            key.add(temp);
        }
    }
    public List<String> letterCombinations(String digits) {
        keyupdate();
        return helper(digits);
    }
    
    
    public List<String> helper(String digits){
        if(digits.length() == 0){
            ArrayList<String> ret = new ArrayList<>();
            return ret;
        }
        List<String> temp = new ArrayList<>();
        int cr = Integer.parseInt(digits.charAt(0)+"");
        List<String> rcvd = helper(digits.substring(1));
        if(rcvd.size() == 0) rcvd.add("");
        for(String str : rcvd){
            for(Character ch: key.get(cr-1)) temp.add(ch + str);
        }
        return temp;
    }
}