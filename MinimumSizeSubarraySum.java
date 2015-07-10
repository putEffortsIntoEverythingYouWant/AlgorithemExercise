/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public class Solution {
    //O(n) since each element will be scanned once
    //if current sum < s , end pointer forward to add more
    //if current sum >= s, compare minLength, forward start pointer to lower the value
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        boolean deductMode = false;
        while(start<=end && end<nums.length){
            if(!deductMode){
                sum+=nums[end];
            }else{
                sum-=nums[start-1];
            }
            if(sum<s){
                end++;
                deductMode = false;
                continue;
            }else{//it's end-start+1 not end-start
                if((end-start+1)<=minLength){
                    minLength = end-start+1;
                    minStart = start;
                }
                start++;
                deductMode = true;
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}