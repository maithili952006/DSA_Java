import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Store all rotten oranges and count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Multi-Source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] d : dir) {

                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 &&
                        newRow < grid.length &&
                        newCol >= 0 &&
                        newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}