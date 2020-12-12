class Solution {
    public int orangesRotting(int[][] grid) {
        int total = grid.length * grid[0].length;
        int check = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.add(i);
                    q.add(j);
                    check++;
                }else if(grid[i][j] == 0) total--;
            }
        }
        if(total == 0) return 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int ans = -1;
        while(q.size() != 0){
            int t = 0;
            for(int i = 0; i < check; i++){
                int a = q.remove();
                int b = q.remove();
                for(int[] d : dir){
                    int r = a + d[0];
                    int c = b + d[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        q.add(r);
                        q.add(c);
                        t++;
                        grid[r][c] = 2;
                    }
                }
                total--;
            }
            ans++;
            check = t;
        }
        //return ans;
        return total == 0? ans : -1;
    }
}