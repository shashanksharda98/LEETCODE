class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        String ans = "";
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int c = Integer.parseInt(""+num.charAt(i));
            while(st.size() != 0 && k != 0 && st.peek() > c){
                st.pop();
                k--;
            }
            if(st.size() == 0 && c == 0) continue;
            else st.push(c);
        }
        if(st.size() == 0) return "0";
        
        if(k > 0){
            while(k != 0){
                st.pop();
                k--;
            }
            while(st.size() != 0) ans = st.pop() + ans;
        }else{
            while(st.size() != 0){
                ans = st.pop() + ans;
            }
        }
        return ans;
    }
}