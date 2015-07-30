/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        List<TreeNode> parent = new ArrayList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()){
            List<TreeNode> child = new ArrayList<TreeNode>();
            List<Integer> value = new ArrayList<Integer>();
            for(TreeNode current: parent){
                value.add(current.val);
                if(current.left!=null){
                    child.add(current.left);
                }
                if(current.right!=null){
                    child.add(current.right);
                }
            }
            parent = child;
            result.add(value);
        }
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        int size = result.size();
        for(int i=size-1; i>=0; i--){
            finalList.add(result.get(i));
        }
        return finalList;
    }
}