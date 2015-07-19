/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

*/
public class Solution {
    public int totalNQueens(int n) {
        int [] result = new int [1];
        String [][] array = new String[n][n];
        solve(n,0,array,result);
        return result[0];
    }
    public void solve(int n, int row, String[][] array,int [] result){
        if(row==n){
            result[0] = result[0]+1;
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

}