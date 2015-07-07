/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode node) {
        int result = calHeight(node);
        if(result==-1){
            return false;
        }
        return true;
    }
    public int calHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = calHeight(node.left);
        int right = calHeight(node.right);
        if(left==-1 || right ==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
        
    }
}