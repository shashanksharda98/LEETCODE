class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ip = new ArrayList<>();
        restoreIpHelper(s, ip, 0, "");
        return ip;
    }
    
    public void restoreIpHelper(String s, List<String> ip, int count, String asf){
        if(s.length() == 0 || count == 4){
            if(s.length() == 0 && count == 4) ip.add(asf.substring(0, asf.length()-1));
            return;
        }
        for(int i = 0; i < 3 && i < s.length(); i++){
            String temp = s.substring(0, i+1);
            int curr = Integer.parseInt(temp);
            if(i == 0 && curr == 0){
                restoreIpHelper(s.substring(1), ip, count+1, asf + temp + ".");
                break;
            }
            if(curr <= 255){
                restoreIpHelper(s.substring(i+1), ip, count+1, asf+temp+".");
            }
        }
        return;
    }
}