/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0){
            return null;
        }
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    public TreeNode build(int [] preorder, int[] inorder, int preS, int preE, int inS, int inE){
        if(preS>preE){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        int locator = inS;
        for(int i=inS; i<=inE; i++){
            if(inorder[i]==preorder[preS]){
                locator = i;
                break;
            }
        }
        int count = locator-inS;
        root.left = build(preorder,inorder,preS+1,preS+count,inS,locator-1);
        root.right = build(preorder,inorder,preS+count+1,preE,locator+1,inE);
        return root;
    }
}