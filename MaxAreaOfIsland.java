class MaxAreaOfIsland {
    
    public int DFS(int[][] grid, boolean[][] visited, int i, int j, final int ROWS, final int COLS){
        if(i<0 || i>=ROWS || j<0 || j>=COLS || grid[i][j] == 0 || visited[i][j]) return 0; 
        visited[i][j] = true;
        return 1 + DFS(grid, visited, i-1, j, ROWS, COLS) + DFS(grid, visited, i+1, j, ROWS, COLS) + DFS(grid, visited, i, j-1, ROWS, COLS) + DFS(grid, visited, i, j+1, ROWS, COLS); 
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length; 
        if(ROWS == 0) return 0; 
        int COLS = grid[0].length;
        if(COLS == 0) return 0;
        boolean[][] visited = new boolean[ROWS][COLS];  
        int globalMax=0;  
        for(int i=0; i<ROWS; i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int localMax = DFS(grid, visited, i, j, ROWS, COLS);
                    globalMax = Math.max(globalMax,localMax);    
                }
            }
        }
        return globalMax;
    }
}
