/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 */ 

public class RangeSumQuery2DMutable {
    int[][] colSum; 
    int[][] matrix; 
    int rows=0; 
    int cols=0; 
    public RangeSumQuery2DMutable (int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return; 
        this.rows = matrix.length; 
        this.cols = matrix[0].length;
        this.colSum = new int[rows+1][cols]; 
        this.colSum = colSum; 
        this.matrix = matrix; 
        for(int i=1; i<=rows; i++) {
            for(int j=0; j<=cols-1;j++){
                colSum[i][j] = colSum[i-1][j] + matrix[i-1][j];  
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i=row+1;i<=colSum.length-1;i++){
            colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val; 
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0; 
        for(int j=col1; j<=col2; j++){
            sum += (colSum[row2+1][j] - colSum[row1][j]); 
        }
        return sum; 
    }
}
