class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Integer> q = new ArrayDeque<>();
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    q.add(i);
                    q.add(j);
                    q.add(0);
                }
            }
        }
        while(q.size() != 0){
            int a = q.remove();
            int b = q.remove();
            int v = q.remove();
            ans[a][b] = v;
            //matrix[a][b] = 0;
            if(a-1 >= 0 && matrix[a-1][b] != 0){
                q.add(a-1);
                q.add(b);
                q.add(v+1);
                matrix[a-1][b] = 0;
            }
            if(a+1 < matrix.length && matrix[a+1][b] != 0){
                q.add(a+1);
                q.add(b);
                q.add(v+1);
                matrix[a+1][b] = 0;
            }
            if(b-1 >= 0 && matrix[a][b-1] != 0){
                q.add(a);
                q.add(b-1);
                q.add(v+1);
                matrix[a][b-1] = 0;
            }
            if(b+1 < matrix[a].length && matrix[a][b+1] != 0){
                q.add(a);
                q.add(b+1);
                q.add(v+1);
                matrix[a][b+1] = 0;
            }
        }
        return ans;
    }
}