/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return;
        }
        int start = 0;
        int end = matrix.length-1;
        while(start<end){
            for(int i=start;i<end;i++){
                int temp = matrix[start][i];
                matrix[start][i]=matrix[end-i+start][start];
                matrix[end-i+start][start] = matrix[end][end-i+start];
                matrix[end][end-i+start]=matrix[i][end];
                matrix[i][end]=temp;
            }
            start++;
            end--;
        }
    }
}