/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

/*
need to maintain the order so can't do start=0, end=length-1
need minimum operation, so start, end should start from begining with available be the first 0, and after each swap, find the next avail(not always current, maybe 0 in the middle)
*/
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        //find first 0 to be available
        int avail = 0;
        while(avail<nums.length && nums[avail]!=0){
            avail++;
        }
        int current = avail+1;
        while(current<nums.length){
            if(nums[current]!=0){
                //switch with avail
                nums[avail] = nums[current];
                nums[current] = 0;
                while(nums[avail]!=0){
                    avail++;
                }
            }
            current++;
        }
    }
}