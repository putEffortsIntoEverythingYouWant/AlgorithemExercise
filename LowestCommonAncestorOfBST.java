/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,(p.val<q.val)?p:q,(p.val<q.val)?q:p);
        
    }
    //prerequisite: p.val < q.val
    //O(n)
    public TreeNode find(TreeNode node, TreeNode p, TreeNode q){
        if(node==null){
            return null;
        }
        if(node == p || node ==q){
            return node;
        }
        boolean isLeft = isSub(node.left,p);
        boolean isRight = isSub(node.right,q);
        if(isLeft && isRight){
            return node;
        }
        
        TreeNode child = (isLeft)?node.left: node.right;
        return find(child,p,q);
    }
    
    public boolean isSub(TreeNode node, TreeNode target){
        if(node ==null ){
            return false;
        }
        if(node == target){
            return true;
        }
        if(node.val < target.val){
            return isSub(node.right,target);
        }
        else{
            return isSub(node.left,target);
        }
    }
   
}