/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length==0 || grid[0].length ==0){
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int [][] sum = new int [rowNum][colNum];
        sum[0][0]=grid[0][0];
        for(int i=1; i<rowNum; i++){
            sum[i][0]=sum[i-1][0]+grid[i][0];
        }
        for(int i=1; i<colNum; i++){
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                sum[i][j]= grid[i][j]+Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }
        return sum[rowNum-1][colNum-1];
    }
}