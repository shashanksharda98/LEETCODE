class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[] arr = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1') arr[j] += 1;
                else arr[j] = 0;
            }
            ans = Math.max(ans, solution(arr));
        }
        return ans;
    }
    public int solution(int[] arr){
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            if(st.size() == 0) st.push(i);
            else{
                while(st.size() != 0 && arr[i] < arr[st.peek()]){
                    int h = arr[st.pop()];
                    int a = (st.size() == 0)? -1 : st.peek();
                    ans = Math.max(ans,(h*(i-a-1)));
                }
                st.push(i);
            }
        }
        int b = arr.length;
        while(st.size() != 0){
            int h = arr[st.pop()];
            int a = (st.size() == 0)? -1: st.peek();
            ans = Math.max(ans, (h*(b-a-1)));
        }
        return ans;
    }
}