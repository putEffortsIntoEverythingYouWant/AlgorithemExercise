/*
For a given sorted array (ascending order) and a target number, 
find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

 First Position of Target Show result 

15:00
 Start
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge
If the count of numbers is bigger than 2^32, can your code work properly?

*/
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums==null){
            return -1;
        }
        return search(nums,target,0,nums.length-1);
    }
    public int search(int [] nums, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(nums[mid]==target){
            if(mid==0 || nums[mid-1]!=target){
                return mid;
            }else{
                return search(nums,target,start,mid-1);
            }

        }
        if(nums[mid]<target){
            return search(nums,target,mid+1,end);
        }else{
            return search(nums,target,start,mid-1);
        }
        
    }
}