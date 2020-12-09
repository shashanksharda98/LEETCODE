class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            if(st.size() == 0) st.push(i);
            else{
                while(st.size() != 0 && heights[i] < heights[st.peek()]){
                    int h = heights[st.pop()];
                    int a = (st.size() == 0)? -1 : st.peek();
                    ans = Math.max(ans, (i-a-1)*h);
                }
                st.push(i);
            }
        }
        while(st.size() != 0){
            int b = heights.length;
            int h = heights[st.pop()];
            int a = (st.size() == 0)? -1 : st.peek();
            ans = Math.max(ans, (b-a-1)*h);
        }
        return ans;
    }
}