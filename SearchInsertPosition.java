/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

/*
point is to additionally check before middle or after middle
don't need to check if start >end, program will return before that

*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A==null || A.length ==0){
            return 0 ;
        }
        return binarySearch(0,A.length-1,target,A);
    }
    public int binarySearch(int start, int end, int target, int[]A){

        int mid = (start+end)/2;
        if(A[mid]==target){
            return mid;
        }
        if(A[mid]>target){
            if(mid-1<0 || A[mid-1]<target){
                return mid;
            }
            return binarySearch(start,mid-1,target,A);
        }
        //A[mid] <target
        if((mid+1)==A.length || A[mid+1] > target){
            return mid+1;
        }
        return binarySearch(mid+1,end,target,A);
    }
}