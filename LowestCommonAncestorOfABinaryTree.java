/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
    //O(n) but not really efficient
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //check if contains p and q, if not, return null
        if(!isSub(root,p) || !isSub(root,q)){
            return null;
        }
        return find(root,p,q);
        
    }
    public TreeNode find(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }
        if(node == p || node == q){
            return node;
        }
        //if p and q is on same side
        boolean resultP = isSub(node.left,p);
        boolean resultQ = isSub(node.left,q);
        if(resultP != resultQ){//p and q in different side
            return node;
        }
        TreeNode child = (resultP)?node.left:node.right;
        return find(child,p,q);
    }
    public boolean isSub(TreeNode node, TreeNode find){
        if(node == null){
            return false;
        }
        if(node == find){
            return true;
        }
        boolean result = isSub(node.left,find);
        if(!result){
            return isSub(node.right,find);
        }else{
            return result;
        }
    }
}