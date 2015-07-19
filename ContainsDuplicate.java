/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length == 0){
            return false;
        }
        Set<Integer> visited = new HashSet<Integer> ();
        boolean result = false;
        for(int i=0; i<nums.length; i++){
            if(visited.contains(nums[i])){
                result = true;
            }
            visited.add(nums[i]);
        }
        return result;
    }
}