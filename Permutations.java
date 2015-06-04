/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public class Solution {
    /*
    very useful solution to make a boolean[] visited...very useful when it comes to path or permutation problems
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        boolean [] visited = new boolean[nums.length];
        permutate(nums,result,current,visited);
        return result;
    }
    
    public void permutate(int [] nums,  List<List<Integer>> result, List<Integer> current, boolean[]visited){
        if(current.size()==nums.length){
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            result.add(copy);
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] == false){//qualified
                visited[i] = true;
                current.add(nums[i]);
                permutate(nums,result,current,visited);
                visited[i]=false;
                current.remove(current.size()-1);//guaranteed always be the last one, since following element would've already been removed
            }
        }
    }
}
