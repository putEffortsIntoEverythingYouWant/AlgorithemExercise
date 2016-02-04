/*
Given a list of numbers, return all possible permutations.
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums==null || nums.isEmpty()){
            return result;
        }
        boolean [] visited = new boolean [nums.size()];
        perm(nums,new ArrayList<Integer>(),result,visited);
        return result;
    }
    
    public void perm(ArrayList<Integer> nums, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result, boolean [] visited){
        if(current.size()==visited.length){
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            result.add(copy);
            return;
        }
        for(int i=0; i<visited.length; i++){
            if(visited[i]==false){
                visited[i] = true;
                current.add(nums.get(i));
                perm(nums,current,result,visited);
                visited[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
    
}
