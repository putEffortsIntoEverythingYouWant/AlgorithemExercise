/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    level order traversal with arraylists, add the last element of each order
    */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        List<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        
        while(!current.isEmpty()){
            result.add(current.get(current.size()-1).val);
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node: current){
                if(node.left!=null){
                    nextLevel.add(node.left);
                }
                if(node.right!=null){
                    nextLevel.add(node.right);
                }
            }
            current = nextLevel;
            
        }
        return result;
    }
}