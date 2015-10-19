/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

//learnt a new average calculation that won't overflow
//also, be careful about the direction of next recursion, not all cases require left/right

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1,n,n);
    }
    public int binarySearch(int start, int end, int n){
        if(start>end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(isBadVersion(mid)){
            if(mid==1 || !isBadVersion(mid-1)){
                return mid;
            }else{
                return binarySearch(start,mid-1,n);
            }
        }
        int right = binarySearch(mid+1,end,n);
        return right;
        
    }
}