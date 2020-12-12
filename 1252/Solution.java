class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for(int[] cr: indices){
            row[cr[0]]++;
            col[cr[1]]++;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) if( (row[i]+col[j]) % 2 != 0) count++;
        }
        return count;
    }
}