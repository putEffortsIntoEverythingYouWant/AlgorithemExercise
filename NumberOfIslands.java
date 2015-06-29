/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
public class Solution {
    //when one 1 found, DFS i+1 j+1 for 1's, change 1's to 0's
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    switchToZero(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public void switchToZero(char[][] grid, int row, int col){
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0){
            return;
        }
        if(grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        switchToZero(grid,row+1,col);
        switchToZero(grid,row-1,col);//for the case of going down and up, if it will be 0, it will stop
        switchToZero(grid,row,col+1);
        switchToZero(grid,row,col-1);
    }
}