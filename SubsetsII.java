/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums==null){
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);//sort the input
        subset(nums,new ArrayList<Integer>(),results,0);
        return results;
    }
    
    public void subset(int [] nums, List<Integer> current, List<List<Integer>> results, int start){
       List<Integer> copy = new ArrayList<Integer>();
       copy.addAll(current);
       results.add(copy);
       
       Set<Integer> visited = new HashSet<Integer>();//make sure same value can not appear twice at same level
       for(int i=start; i<nums.length; i++){
           if(!visited.contains(nums[i])){
               current.add(nums[i]);
               visited.add(nums[i]);
               subset(nums,current,results,i+1);
               current.remove(current.size()-1);
               
           }
       }
    }
}