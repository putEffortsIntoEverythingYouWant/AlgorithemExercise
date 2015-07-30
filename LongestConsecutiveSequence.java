/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Tags
*/
public class Solution {
    //first scan the array, put record into map 
    public int longestConsecutive(int[] nums) {
        
        if(nums==null){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int length = 0;
        for(int i=0;i<nums.length; i++){
            if(set.contains(nums[i])){//not visited before
                int count = 1;
                set.remove(nums[i]);
                //count smaller
                int smaller = nums[i]-1;
                while(set.contains(smaller)){
                    count++;
                    set.remove(smaller);
                    smaller = smaller-1;
                }
                //count bigger
                int bigger = nums[i]+1;
                while(set.contains(bigger)){
                    count++;
                    set.remove(bigger);
                    bigger = bigger+1;
                }
                if(count>length){
                    length = count;
                }
            
            }
            
        }
        return length;
        
    }
}