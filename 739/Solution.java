class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < T.length; i++){
            if(st.size() == 0) st.push(i);
            else{
                while(st.size() != 0 && T[st.peek()] < T[i]){
                    ans[st.peek()] = i - st.pop(); 
                }
                st.push(i);
            }
        }
        return ans;
    }
}