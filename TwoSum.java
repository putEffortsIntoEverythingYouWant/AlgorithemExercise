/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a hashmap with values, and for each nums[i], see if hashmap contains target-nums[i]
        int[] results = new int[2];
        if(nums==null || nums.length<2){
            return results;
        }
        Map<Integer,Integer> records = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            records.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            if(records.containsKey(target-nums[i])){
                int index2 = records.get(target-nums[i]);
                if(index2==i){
                    continue;//eliminate case of the same element
                }
                results[0]=Math.min(index2+1,i+1);
                results[1]=Math.max(index2+1,i+1);
                return results;
            }
        }
        return results;
    }
}