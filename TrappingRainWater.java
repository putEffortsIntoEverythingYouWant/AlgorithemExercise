/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/
public class Solution {
    //initial thought was to use a stack to record all descending elements and 
    //start to pop when found next ascending group, it's complicately to handle all corner cases
    //this question is about relative standing on left/right neighbors..
    //therefore should think of double scanning: left to right, right to left, to find maximum left and right values, and take the min minus own value is the value of current element
    //it's better to look and caluclate each elements water than dealing with distance*height
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int max1 = 0;
        int max2 = 0;
        int [] left = new int [height.length];
        int [] right = new int [height.length];
        for(int i=0; i<height.length; i++){
            if(height[i]>max1){
                max1 = height[i];
            }
            left[i]=max1;
        }
        
        for(int i=height.length-1; i>=0; i--){
            if(height[i]>max2){
                max2 = height[i];
            }
            right[i]=max2;
        }
        int sum = 0;
        
        for(int i=0; i<height.length; i++){
            sum+=Math.min(left[i],right[i])-height[i];//never be negative
        }
        return sum;
    }
}