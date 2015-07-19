/*
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> position = new HashMap<Integer,Integer>();
        if(nums == null){
            return false;
        }
        for(int i=0; i<nums.length; i++){
            if(position.containsKey(nums[i]) && i<=position.get(nums[i])){
               return true;
            }else{
                position.put(nums[i],i+k);
            }
            
        }
        return false;
    }
}