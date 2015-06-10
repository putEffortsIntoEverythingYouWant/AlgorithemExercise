/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
public class Solution {
//create helper matrix
//initiate first row and first col as what it is
//if matrix[i][j]=='0',square[i][j]==0
//if matrix[i][j]=='1', square[i][j] is min of (matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]) + 1,so it will at least be 1
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int [][] square = new int[rowNum][colNum];
        for(int i=0; i<rowNum; i++){
            square[i][0] = (matrix[i][0]=='1')?1:0;
        }
        for(int j=0; j<colNum; j++){
            square[0][j] = (matrix[0][j]=='1')?1:0;
        }
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum;j++){
                if(matrix[i][j]=='0'){
                    square[i][j] = 0;
                    continue;
                }
                square[i][j] = Math.min(Math.min(square[i-1][j],square[i][j-1]),square[i-1][j-1])+1; 
                
                
            }
        }
        int maxNum = 0;
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(square[i][j]>maxNum){
                    maxNum = square[i][j];
                }
            }
        }
        return maxNum*maxNum;
        
    }
}