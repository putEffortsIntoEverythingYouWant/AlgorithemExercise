/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
       if(nums==null){
            return 0;
        }
        int length = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=s){//since it's sum>=s, so we can update for each possible case, no need to wait for the mini one,
                length = Math.min(length,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
}