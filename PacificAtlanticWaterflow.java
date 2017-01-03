/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */ 

public class PacificAtlanticWaterflow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<int[]>(); 
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list; 
        int rows = matrix.length, cols=matrix[0].length;
        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];
        //Spread from left boundary for Pacific
        for(int i=0; i<=rows-1; i++){
            DFS(matrix, canReachPacific, rows, cols, i, 0, matrix[i][0]); 
        }
        //Spread from top boundary for Pacific
        for(int j=0; j<=cols-1; j++){
            DFS(matrix, canReachPacific, rows, cols, 0, j, matrix[0][j]); 
        }
        //Spread from right boundary for Atlantic
        for(int i=0; i<=rows-1; i++){
            DFS(matrix, canReachAtlantic, rows, cols, i, cols-1, matrix[i][cols-1]); 
        }
        //Spread from bottom boundary for Atlantic
        for(int j=0; j<=cols-1; j++) {
            DFS(matrix, canReachAtlantic, rows, cols, rows-1, j, matrix[rows-1][j]); 
        }
        
        for(int i=0; i<=rows-1; i++){
            for(int j=0; j<=cols-1; j++){
                if(canReachPacific[i][j] && canReachAtlantic[i][j]){
                    int[] arr = new int[2];
                    arr[0] = i; 
                    arr[1] = j; 
                    list.add(arr);
                }
            }
        }
        return list; 
    }
    
    private void DFS(int[][] matrix, boolean[][] visited, int rows, int cols, int i, int j, int prevHeight){
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || matrix[i][j] < prevHeight) return; 
        visited[i][j] = true;
        DFS(matrix, visited, rows, cols, i-1, j, matrix[i][j]);
        DFS(matrix, visited, rows, cols, i+1, j, matrix[i][j]);
        DFS(matrix, visited, rows, cols, i, j-1, matrix[i][j]);
        DFS(matrix, visited, rows, cols, i, j+1, matrix[i][j]);
    }
}