/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/
/*
binary search with a changed condition
*/
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null){
            return -1;
        }
        return binarySearch(0,nums.length-1,nums);
    }
    
    public int binarySearch(int start, int end, int [] nums){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if((mid-1 == -1 || nums[mid-1]<nums[mid]) && (mid+1==nums.length || nums[mid+1]<nums[mid])){
            return mid;
        }
        if(mid-1 >= 0 && nums[mid-1]>=nums[mid]){
            return binarySearch(start,mid-1,nums);
        }
        else{
            return binarySearch(mid+1,end,nums);
        }
    }
}