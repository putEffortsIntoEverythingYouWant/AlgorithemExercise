/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    /*
    besides boolean[]visited, just in each level of recursion, add a hashset to see if value has been iterated before
    basically in each level, keep one value only appear once
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return result;
        }
        permutate(nums,new ArrayList<Integer>(), result,new boolean[nums.length]);
        return result;
    }
    
    public void permutate(int [] nums, List<Integer>current, List<List<Integer>> result, boolean[] visited){
        if(current.size()==nums.length){
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            result.add(copy);
            return;
        }
        Set<Integer> visitedInLevel = new HashSet<Integer>();
        for(int i=0; i<nums.length ;i++){
            if(visited[i]==false && !visitedInLevel.contains(nums[i])){
                current.add(nums[i]);
                visited[i]=true;
                visitedInLevel.add(nums[i]);
                permutate(nums,current,result,visited);
                visited[i]=false;
                current.remove(current.size()-1);
            }
        }
    }
}