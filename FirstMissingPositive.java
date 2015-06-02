/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
   //like a sorting
   //be sure to make the stio condition right
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i+1){
                if(nums[i]>nums.length || nums[i]<=0 || nums[i]==nums[nums[i]-1]){
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}