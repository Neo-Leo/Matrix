/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * T(n) = O(mn)	
 */ 

public class RangeSumQuery2DImmutable {
    int [][] mat = null;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        for(int i=0;i<=matrix.length-1;i++){
            for(int j=1;j<=matrix[0].length-1;j++) {
                matrix[i][j] += matrix[i][j-1];
            }    
        }
        
        for(int i=1;i<=matrix.length-1;i++){
            for(int j=0;j<=matrix[0].length-1;j++) {
                matrix[i][j] += matrix[i-1][j];
            }    
        }
        
        mat = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(mat == null){
            return 0;
        }
        int sum=0;
        if(row1 == 0 && col1 == 0) return mat[row2][col2];
        else if(col1 == 0) return mat[row2][col2]-mat[row1-1][col2]; 
        else if(row1 == 0) return mat[row2][col2]-mat[row2][col1-1];
        else return mat[row2][col2] - mat[row1-1][col2] - mat[row2][col1-1] + mat[row1-1][col1-1];  
    }
}