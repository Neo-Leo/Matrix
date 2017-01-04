/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/island-perimeter/
 */ 

public class Solution {
    public int wrapper(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return 1; 
        if(grid[i][j] == -1) return 0; 
        grid[i][j] = -1; 
        int result = 0;
        result += wrapper(grid,i-1,j); 
        result += wrapper(grid,i+1,j);
        result += wrapper(grid,i,j-1); 
        result += wrapper(grid,i,j+1);
        return result; 
    }
    
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; 
        int rows = grid.length, cols = grid[0].length;
        int[] result = new int[1]; 
        for(int i=0;i<=rows-1;i++){
            for(int j=0;j<=cols-1;j++){
                if(grid[i][j] == 1){
                    return wrapper(grid, i, j); 
                }
            }
        }
        return 0;
    }
}
