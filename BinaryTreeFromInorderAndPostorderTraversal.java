/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0){
            return null;
        }
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode build(int [] inorder, int [] postorder, int sIn, int eIn,int sPost, int ePost){
        if(sIn>eIn){
            return null;
        }
        int rootValue = postorder[ePost];
        TreeNode root = new TreeNode(rootValue);
        int position = 0;
        for(int i=sIn; i<=eIn;i++){
            if(inorder[i]==rootValue){
                position = i;
                break;
            }
        }
        TreeNode left = build(inorder,postorder,sIn,position-1,sPost,sPost+(position-1-sIn));
        TreeNode right = build(inorder,postorder,position+1,eIn,sPost+position-sIn,ePost-1);
        root.left = left;
        root.right = right;
        return root;
    }
}