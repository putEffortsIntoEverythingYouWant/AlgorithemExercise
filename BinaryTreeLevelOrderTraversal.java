/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
 /*
 recursion with level number which corresponsed to result array index
 or while loop with set of parent and children 
 or queue
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> currentInt = new ArrayList<Integer>();
        List<TreeNode> currentNode = new ArrayList<TreeNode>();
        if(root != null){
            currentNode.add(root);
            currentInt.add(root.val);
        }
        while(currentNode.size()>0){
            List<TreeNode> parent = currentNode;
            currentNode = new ArrayList<TreeNode>();
            results.add(currentInt);
            currentInt = new ArrayList<Integer>();
            for(TreeNode node: parent){
                if(node.left!=null){
                    currentInt.add(node.left.val);
                    currentNode.add(node.left);
                }
                if(node.right!=null){
                    currentInt.add(node.right.val);
                    currentNode.add(node.right);
                }
            }
        }
        return results;
    }
}