/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/lonely-pixel-i/
 */ 

public class LonelyPixel1 {
    public int findLonelyPixel(char[][] picture) {
         if(picture == null) return 0; 
         int rows=picture.length, cols=picture[0].length,count=0; 
         if(rows == 0 || cols == 0) return 0;
         int[] rowCount = new int[rows]; 
         int[] colCount = new int[cols]; 
         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(picture[i][j] == 'B'){
                     rowCount[i]++; 
                     colCount[j]++; 
                 }
             }
         }
         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1){
                     count++;
                 }
             }
         }
         return count; 
    }
}