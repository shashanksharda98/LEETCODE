class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodfill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    public void floodfill(int[][] image, int sr, int sc, int newColor, int k){
        if(sr >= image.length || sr < 0 || sc < 0 || sc >= image[0].length || image[sr][sc] != k || image[sr][sc] == newColor){
            return;
        }
        image[sr][sc] = newColor;
        floodfill(image, sr+1, sc, newColor, k);
        floodfill(image, sr-1, sc, newColor, k);
        floodfill(image, sr, sc+1, newColor, k);
        floodfill(image, sr, sc-1, newColor, k);
    }
}