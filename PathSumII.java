/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root==null){return results;}
        calculateSum(root,sum,0,new ArrayList<Integer>(),results);
        return results;
    }
    
    public void calculateSum(TreeNode node, int sum, int currentSum, List<Integer> values, List<List<Integer>> results){
        //stop the recursion at parent node level to avoid repetitively calculation , ex: [1], 1
        int newSum = currentSum+node.val;
        values.add(node.val);
        if(node.left==null && node.right==null){
            if(newSum == sum){
                List<Integer> copy = new ArrayList<Integer>();
                copy.addAll(values);
                results.add(copy);
            }
        }
    
        if(node.left!=null){
             calculateSum(node.left,sum,newSum,values,results);
        }
        if(node.right!=null){
            calculateSum(node.right,sum,currentSum+node.val,values,results);
        }
        values.remove(values.size()-1);
        
    }
}