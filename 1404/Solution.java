class Solution {
    public int numSteps(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(s.length()-1) == '1'){
            if(s.length() == 1) return 0;
            int temp = 0;
            int i = s.length() - 1;
            while(i >= 0){
                if(s.charAt(i) == '1') temp++;
                else{
                    //temp = s.substring(0, i) + "1" + temp;
                    break;
                }
                i--;
            }
            if(i == -1) return temp + 1;
            return 1 + temp + numSteps(s.substring(0, i) + "1");
        }else{
            return 1 + numSteps(s.substring(0, s.length()-1));
        }
    }
}