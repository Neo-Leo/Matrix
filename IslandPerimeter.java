/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/island-perimeter/
 */ 

public class Solution {
    public void wrapper(int[][] grid, int i, int j, int[] result){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 1) return; 
        grid[i][j] = 2; 
        int top = (i==0 || grid[i-1][j] == 0) ? 1 : 0; 
        int bottom = (i==grid.length-1 || grid[i+1][j] == 0) ? 1 : 0;
        int left = (j==0 || grid[i][j-1] == 0) ? 1 : 0; 
        int right = (j == grid[0].length-1 || grid[i][j+1] == 0) ? 1 : 0;
        result[0] += (left+right+bottom+top);
        wrapper(grid,i-1,j,result); 
        wrapper(grid,i+1,j,result);
        wrapper(grid,i,j-1,result); 
        wrapper(grid,i,j+1,result);
    }
    
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; 
        int rows = grid.length, cols = grid[0].length;
        int[] result = new int[1]; 
        for(int i=0;i<=rows-1;i++){
            for(int j=0;j<=cols-1;j++){
                if(grid[i][j] == 1){
                    wrapper(grid, i, j, result); 
                    break; 
                }
            }
        }
        return result[0];
    }
}