/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge
O(log(n) + log(m)) time


//tip: becareful that row search is a range broad search
*/
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null){
            return false;
        }
        int rowNum = searchForRow(matrix,target,0,matrix.length-1);
        if(rowNum == -1){
            return false;
        }
        if(searchForCol(matrix[rowNum],target,0,matrix[rowNum].length-1)==-1){
            return false;
        }
        return true;
        
    }
    public int searchForCol(int [] row, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(row[mid]==target){
            return mid;
        }
        if(row[mid]>target){
            return searchForCol(row,target,start,mid-1);
        }
        return searchForCol(row,target,mid+1,end);
    }
    
    public int searchForRow(int [][]matrix, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(matrix[mid][0]==target){
            return mid;
        }
        if(matrix[mid][0]>target){
            if(mid!=0 && matrix[mid-1][0]<=target){
                return mid-1;
            }else{
                return searchForRow(matrix,target,start,mid-1);
            }
            
        }else{//<target
            if(mid==matrix.length-1 || matrix[mid+1][0]>target){
                return mid;
            }else{
                return searchForRow(matrix,target,mid+1,end);
            }
        }
        
    }
}
