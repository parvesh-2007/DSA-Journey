class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        // Step 1: Saare rotten oranges queue mein daalo
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 4 directions
        int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        // Step 2: BFS
        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for(int k = 0; k < size; k++) {

                int[] current = q.poll();

                int i = current[0];
                int j = current[1];

                for(int[] dir : directions) {

                    int r = i + dir[0];
                    int c = j + dir[1];

                    if(r >= 0 && r < m &&
                       c >= 0 && c < n &&
                       grid[r][c] == 1) {

                        grid[r][c] = 2;
                        fresh--;

                        q.add(new int[]{r, c});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
    
