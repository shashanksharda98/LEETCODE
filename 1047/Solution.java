class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(stack.size() != 0 && stack.peek() == ch){
                stack.pop();
            }
            else stack.push(ch);
        }
        String ans = "";
        while(stack.size() != 0){
            ans = (""+ stack.pop() + ans);
        }
        return ans;
    }
}