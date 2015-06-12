/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = calculateEachArea(A,B,C,D);
        int area2 = calculateEachArea(E,F,G,H);
        //calculate overlap
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        if((top<=bottom) || (left>=right)){//no overlap
            return area1+area2;
        }
        return area1+area2-(right-left)*(top-bottom);
        
    }
    public int calculateEachArea(int A, int B, int C, int D){
        return Math.abs(A-C)*Math.abs(B-D);
    }
    
    
}