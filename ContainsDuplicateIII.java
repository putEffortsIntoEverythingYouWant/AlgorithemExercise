/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/
public class Solution {
    //maintain balanced search tree to search for elements
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null){
            return false;
        }
        if(k<1 || t<0){
            return false;
        }
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if((tree.ceiling(nums[i]-t)!=null && nums[i]>=tree.ceiling(nums[i]-t))
            ||(tree.floor(t+nums[i])!=null && tree.floor(t+nums[i])>=nums[i])){
                return true;
            }
            tree.add(nums[i]);
            if(i>=k){
                tree.remove(nums[i-k]);
            }
        }
        return false;
    }
}