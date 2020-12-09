class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else if(st.size() > 0 && c == ')'){
                char top = st.peek();
                if(top == '(') st.pop();
                else return false;
            }else if(st.size() > 0 && c == '}'){
                char top = st.peek();
                if(top == '{') st.pop();
                else return false;
            }else if(st.size() > 0 && c == ']'){
                char top = st.peek();
                if(top == '[') st.pop();
                else return false;
            }else return false;
        }
        if(st.size() == 0) return true;
        return false;
    }
}