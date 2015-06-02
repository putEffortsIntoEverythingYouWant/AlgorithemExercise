/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
public class Solution {
    /*
    important: for [0][j] and [i][0], have an indicator to record if any previous element is 1, turn on the indicator in that case;
    if indicator is true, for any following elements, no matter what value in obstacleGrid, it's 0
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int rowNum = obstacleGrid.length;
     int colNum = obstacleGrid[0].length;
     int [][] paths = new int[rowNum][colNum];
     boolean blocked = false;
     for(int i=0; i<rowNum; i++){
         if(obstacleGrid[i][0] == 1 || blocked){
             if(!blocked){
                 blocked = true;
             }
             paths[i][0] = 0;
         }else{
             paths[i][0] = 1;
         }
     }
     blocked = false;
     for(int j=0; j<colNum; j++){
         if(obstacleGrid[0][j] == 1 || blocked){
             if(!blocked){
                 blocked = true;
             }
             paths[0][j] = 0;
         }else{
             paths[0][j] = 1;
         }
     }
     for(int i=1; i<rowNum; i++){
         for(int j=1; j<colNum; j++){
             if(obstacleGrid[i][j] == 1){
                 paths[i][j] = 0;
             }
             else{
                 paths[i][j] = paths[i-1][j] + paths[i][j-1];
             }
         }
     }
     return paths[rowNum-1][colNum-1];
     
    }
}