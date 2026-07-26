class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 1. Declare and initialize startingColor
        int startingColor = image[sr][sc];
        
        // 2. Fixed typos here
        if (startingColor != color) {
            dfs(image, sr, sc, startingColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int startingColor, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        // Check boundary conditions and matching color
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != startingColor) {
            return;
        }
        
        // Update pixel color
        image[r][c] = color;
        
        // Traverse 4-directionally: Down, Up, Right, Left
        dfs(image, r + 1, c, startingColor, color);
        dfs(image, r - 1, c, startingColor, color);
        dfs(image, r, c + 1, startingColor, color);
        dfs(image, r, c - 1, startingColor, color);
    }
}