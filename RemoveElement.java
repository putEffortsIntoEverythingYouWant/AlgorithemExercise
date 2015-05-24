/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
/*
 nothing special, just pay attention to details
*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null){
            return -1;
        }
        int avail = 0;
        int current = 0;
        int newLength = 0;
        while(current<nums.length){
            if(nums[current]!=val){
                nums[avail]=nums[current];
                avail++;
                newLength++;
            }
            current++;
        }
        return newLength;
    }
}