class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else{
                if(i == 0 && j == 0) return false;
                if(typed.charAt(j) == typed.charAt(j-1)) j++;
                else return false;
            }
        }
        if(i != name.length()) return false;
        return true;
    }
}