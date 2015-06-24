/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
public class Solution {
    //use the first col and first row to store indicator
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length == 0){return;}
        boolean firstColZero = false;
        boolean firstRowZero = false;
        int rowNum= matrix.length;
        int colNum = matrix[0].length;
        for(int i=0; i<rowNum; i++){
            if(matrix[i][0]==0){
                firstColZero = true;
            }
        }
        for(int i=0; i<colNum; i++){
            if(matrix[0][i]==0){
                firstRowZero = true;
            }
        }
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstColZero){
            for(int i=0; i<rowNum; i++){
                matrix[i][0]=0;
            }
        }
        if(firstRowZero){
            for(int i=0; i<colNum; i++){
                matrix[0][i]=0;
            }
        }
        
    }
}