/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class Solution {
    //using a two dimention array is not a very good option because it's hard to maintain the right status and revert it back after done with current loop
    //therefore, only set and revert one cell value, for each cell..check if it's valid
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        String [][] array = new String[n][n];
        solve(n,0,array,result);
        return result;
    }
    public void solve(int n, int row, String[][] array,List<List<String>> result){
        if(row==n){
            result.add(formList(array));
            return;
        }
        for(int col = 0; col<array.length; col++){
            array[row][col]=".";
        }
        for(int col = 0; col<array.length; col++){
            if(isValid(row,col,array)){
                array[row][col]="Q";
                solve(n,row+1,array,result);
                array[row][col]=".";
            }
        }
    }
    public boolean isValid(int row, int col, String [][] array){
        //check col, only check upper
        for(int i=0;i<row;i++){
            if(array[i][col].equals("Q")){
                return false;
            }
        }
        //check left diagose, only check upper 
        int l1 = row-1;
        int l2 = col-1;
        while(l1>=0 && l2>=0){
            if(array[l1][l2].equals("Q")){
                return false;
            }
            l1=l1-1;
            l2=l2-1;
        }
        //check right diagonal, only check upper
        int r1= row-1;
        int r2 = col+1;
        while(r1>=0 && r2<=array.length-1){
            if(array[r1][r2].equals("Q")){
                return false;
            }
            r1 = r1-1;
            r2 = r2+1;
        }
        return true;
    }
    public List<String> formList(String [][] array){
        StringBuilder builder = new StringBuilder();
        List<String> row = new ArrayList<String>();
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                builder.append(array[i][j]);
            }
            row.add(builder.toString());
            builder.setLength(0);
        }
        return row;
    }
}