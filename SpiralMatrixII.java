/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int [n][n];
        int start = 0;
        int end = n-1;
        int value = 1;
        while(start<=end){
            value = generate(matrix,start,end,value);
            start++;
            end--;
        }
        return matrix;
        
    }
    //return next value
    public int generate(int [][] matrix, int start, int end, int value){
        if(start==end){
            matrix[start][start] = value;
            return value+1;
        }else{
            for(int i=start; i<end; i++){
                matrix[start][i] = value;
                value++;
            }
            for(int i=start; i<end; i++){
                matrix[i][end] = value;
                value++;
            }
            for(int i=end; i>start; i--){
                matrix[end][i]=value;
                value++;
            }
            for(int i=end; i>start; i--){
                matrix[i][start] = value;
                value++;
            }
            return value;
        }
    }
}