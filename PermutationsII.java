/*
Given a list of numbers with duplicate number in it. Find all unique permutations.
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums==null || nums.isEmpty()){
            return result;
        }
        boolean [] visited = new boolean [nums.size()];
        perm(nums,visited,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void perm(ArrayList<Integer> nums, boolean [] visited, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result){
        if(current.size()==visited.length){
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            result.add(copy);
            return;
        }
        Set<Integer> contained = new HashSet<Integer>();
        for(int i=0; i<visited.length; i++){
            if(visited[i]==false){
                if(!contained.contains(nums.get(i))){
                    contained.add(nums.get(i));
                    visited[i]=true;
                    current.add(nums.get(i));
                    perm(nums,visited,current,result);
                    visited[i]=false;
                    current.remove(current.size()-1);
                }
            }
        }
    }
}
