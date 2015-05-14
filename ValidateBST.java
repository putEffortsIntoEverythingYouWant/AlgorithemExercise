/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means?
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 in order travel..nothing fancy
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        inOrderTraversal(values,root);
        for( int i=0; i<values.size()-1;i++){
            if(values.get(i+1)<=values.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public void inOrderTraversal(List<Integer> values, TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            inOrderTraversal(values,node.left);
        }
        values.add(node.val);
        if(node.right!=null){
            inOrderTraversal(values,node.right);
        }
    }
}