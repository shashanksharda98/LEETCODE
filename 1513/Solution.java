class Solution {
    public int numSub(String s) {
        long ans = 0;
        int lensofar = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') lensofar = 0;
            else{
                ans += (lensofar + 1);
                lensofar++;
            }
        }
        return (int)(ans%(1000000000+7));
    }
}