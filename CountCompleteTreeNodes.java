/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    /*
    O(h*h) instead of O(n)
    */
    public int countNodes(TreeNode root) {
        return count(root);
    }
    public int count(TreeNode node){
        
        int leftHeight = 0;
        int rightHeight = 0;
        
        TreeNode point1 = node;
        while(point1!=null){
            leftHeight++;
            point1=point1.left;
        }
        
        TreeNode point2 = node;
        while(point2!=null){
            rightHeight++;
            point2 = point2.right;
        }
        
        if(leftHeight == rightHeight){
            return powerTwo(leftHeight)-1;
        }
        
        return count(node.left) + count(node.right) +1;
        
    }
    /*
    Math.pow() require double...don't like dealing with converting types..
    */
    public int powerTwo(int num){
        int result = 1;
        while(num>0){
            result*=2;
            num--;
        }
        return result;
    }
}