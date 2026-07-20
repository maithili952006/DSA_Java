import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        // Brute Force Approach

        int rows = grid.length;
        int cols = grid[0].length;
        int time = 0;

        while (true) {

            boolean changed = false;

            // Find all rotten oranges
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (grid[i][j] == 2) {

                        // Up
                        if (i > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 3;
                            changed = true;
                        }

                        // Down
                        if (i < rows - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            changed = true;
                        }

                        // Left
                        if (j > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 3;
                            changed = true;
                        }

                        // Right
                        if (j < cols - 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            changed = true;
                        }
                    }
                }
            }

            // If no orange became rotten, stop
            if (!changed) {
                break;
            }

            // Convert all 3's into 2's
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }

            time++;
        }

        // Check if any fresh orange is left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}