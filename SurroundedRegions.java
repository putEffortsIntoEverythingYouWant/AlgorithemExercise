/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public class Solution {
    public void solve(char[][] board) {
        //inner elements are qualifed for sure, we need to check from the edge, all the elements that are at the edge or connected with the edge elements are not qualified, we change them to '#'(so no need to use extra space)
        //at the end, scan through the array, if '#' change back to 'O', if'O', change to 'X'
        //this will eliminate lots of recursion calls on inner elements
        if(board==null || board.length==0 || board[0]==null || board[0].length==0){
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;
        //first row
        for(int i=0;i<colNum; i++){
            if(board[0][i]=='O'){
                search(board,0,i);
            }
        }
        //first col
        for(int i=0; i<rowNum; i++){
            if(board[i][0]=='O'){
                search(board,i,0);
            }
        }
        //last row
        for(int i=0;i<colNum; i++){
            if(board[rowNum-1][i]=='O'){
                search(board,rowNum-1,i);
            }
        }
        //last col
        for(int i=0;i<rowNum; i++){
            if(board[i][colNum-1]=='O'){
                search(board,i,colNum-1);
            }
        }
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void search(char [][] board, int row, int col){
        Stack<RowCol> stack = new Stack<RowCol>();
        stack.push(new RowCol(row,col));
        while(!stack.empty()){
            RowCol pair = stack.pop();
            board[pair.row][pair.col]='#';
             if(pair.row-1 >=0 && board[pair.row-1][pair.col]=='O'){
                stack.push(new RowCol(pair.row-1,pair.col));
             }
             if(pair.row+1<board.length && board[pair.row+1][pair.col]=='O'){
                stack.push(new RowCol(pair.row+1,pair.col));
            }
            if(pair.col-1>=0 && board[pair.row][pair.col-1]=='O'){
                stack.push(new RowCol(pair.row,pair.col-1));
            }
            if(pair.col+1<board[0].length && board[pair.row][pair.col+1]=='O'){
               stack.push(new RowCol(pair.row,pair.col+1));
            }
        }
    }
        /*recursive way throw stackoverflowerror, need to do it iteratively
    public void search(char [][] board, int row, int col,int rowNum, int colNum){

        board[row][col]='#';
        if(row-1 >=0 && board[row-1][col]=='O'){
            search(board,row-1,col,rowNum,colNum);
        }
        if(row+1<rowNum && board[row+1][col]=='O'){
            search(board,row+1,col,rowNum,colNum);
        }
        if(col-1>=0 && board[row][col-1]=='O'){
            search(board,row,col-1,rowNum,colNum);
        }
        if(col+1<colNum && board[row][col+1]=='O'){
            search(board,row,col+1,rowNum,colNum);
        }
    }
    */
    public class RowCol{
        int row;
        int col;
        public RowCol(int i, int j){
            row = i;
            col=j;
        }
    }
    
}
/*
the following method works perfectly but throws stackoverflowerrors on large data, because it has unnecessary recursion calls.....inner elements are qualified for sure, no need to check on them
public class Solution {
    //for ij,. surrounding means [i-1][j],[i+1][j],[i][j-1],[i][j+1]
    //scan through board, if find one 0, recursively see if it all souroundings are 4 X or qualified 0s(have 3 X and one 0 is already visited(where current recursion came from)), if itself is qualified or all 0 surroundings returns qualifies, set itself to X and then return true; if itself is edgy element, return false
    public void solve(char[][] board) {
        //=0 and visited =false
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        boolean [][] visited = new boolean [board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    scan(board,visited,i,j);
                }
            }
        }
        
    }
    public boolean scan(char [][] board, boolean [][] visited, int row, int col){
     if(row-1<0 || row+1==board.length || col-1<0 || col+1==board[0].length){
         visited[row][col]=true;
         return false;
     }   
     if(board[row-1][col]=='X' && board[row+1][col]=='X' && board[row][col-1]=='X' && board[row][col+1]=='X'){
         visited[row][col] = true;
         board[row][col]='X';
         return true;
     }
     visited[row][col]=true;
     if(board[row-1][col]=='O' && !visited[row-1][col]){
         if(!scan(board,visited,row-1,col)){
             return false;
         }
     }
    if(board[row+1][col]=='O' && !visited[row+1][col]){
         if(!scan(board,visited,row+1,col)){
             return false;
         }
     }
    if(board[row][col-1]=='O' && !visited[row][col-1]){
         if(!scan(board,visited,row,col-1)){
             return false;
         }
     }
    if(board[row][col+1]=='O' && !visited[row][col+1]){
         if(!scan(board,visited,row,col+1)){
             return false;
         }
     }
     board[row][col]='X';
     return true;
     
    }
}
*/
