class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int res = 0;

        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(grid[i][j] == 1)
                    fresh++;

                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        while(fresh > 0 && q.size() > 0) {
            int len = q.size();
            for(int i = 0; i<len; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for(int[] dir: dirs){
                    int newr = x + dir[0];
                    int newc = y + dir[1];
                    if(newr >= 0 && newr < rows && newc >= 0 && newc < cols 
                    && grid[newr][newc] == 1) {
                        grid[newr][newc] = 2;
                        q.add(new int[]{newr, newc});
                        fresh--;
                    }
                }
            }
            res++;
        }

        return fresh > 0 ? -1 : res;
    }
}
