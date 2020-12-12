class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(st.size() == 0 || c == '(') st.push(c);
            else{
                if(st.peek() == '(') st.pop();
                else st.push(c);
            }
        }
        return st.size();
    }
}