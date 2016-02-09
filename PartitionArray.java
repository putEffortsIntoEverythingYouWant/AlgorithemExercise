/*
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

If nums = [3,2,2,1] and k=2, a valid answer is 1.

O(n)

key point is to move end pointer forward till next available spot everytime swap happens
*/
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums==null || nums.length==0){
	        return 0;
	    }
	    int start = 0;
	    while(start<nums.length && nums[start]<k){
	        start++;
	    }
	    int end = nums.length-1;
	    while(end>=0 && nums[end]>=k ){
	        end--;
	    }
	    while(start<end){
	        
	        if(nums[start]>=k){
	            int temp = nums[end];
	            nums[end] = nums[start];
	            nums[start] = temp;
	            start++;
	            
	            while(nums[end]>=k){
	                end--;
	            }
	        }else{
	            start++;
	        }
	        
	        
	    }
	    int index = 0;
	    while(index<nums.length && nums[index]<k){
	        index++;
	    }
	    return index;
    }
}