/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

/*
calculate max sum of both left and right tree while only return 
either left +current or right tree + current
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
    public int maxPathSum(TreeNode root) {
     int [] sum = new int[1];   
     sum[0]=Integer.MIN_VALUE;
     searchTree(root,sum);
     return sum[0];
    }
    
    public int searchTree(TreeNode node, int [] nums){
        if(node==null){
            return 0;
        }
        int left = searchTree(node.left,nums);
        int right = searchTree(node.right,nums);
        int returnValue = Math.max(node.val+((left>0)?left:0), node.val+((right>0)?right:0));
        int currentSum = node.val+((left>0)?left:0)+((right>0)?right:0);
        nums[0] = Math.max(nums[0],currentSum);
        return returnValue;
    }
}