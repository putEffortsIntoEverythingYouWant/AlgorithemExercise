/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution {
    //maintain a max cover range
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<=1){
            return true;
        }
        int maxIndex = 0;
        int current =0;
        while(current<=maxIndex){
            
                maxIndex= Math.max(maxIndex,current+nums[current]);
                if(maxIndex>=nums.length-1){
                    return true;
                 }
            

            current++;
        }
        return false;
    }
}