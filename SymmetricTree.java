/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
 similar logic as level by level traversal,
 recursively by creating arraylist for each level and pass along level num in each recursion call
 iterative by using queue or just simply maintain pointers to nodes at each level as an arraylist
 make sure left child and right child are distinguished from each other
 
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){ return true;}
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        List<TreeNode> childNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);

        while(levelNodes.size()>0){
            int start = 0;
            int end = levelNodes.size()-1;
            while(start<=end){
                TreeNode node1 = levelNodes.get(start);
                TreeNode node2 = levelNodes.get(end);
                //left child of node1 = right child of node2
                //right child of node1 = left child of node2
                if((node1.left == null && node2.right != null) ||
                    (node1.left!=null && node2.right == null) ||
                    (node1.left!=null && node2.right != null && node1.left.val != node2.right.val)){
                    return false;
                }
                if((node1.right == null && node2.left != null) ||
                    (node1.right != null && node2.left == null) ||
                    (node1.right != null && node2.left != null && node1.right.val != node2.left.val)){
                    return false;
                }
                start++;
                end--;
            }
        for(TreeNode node: levelNodes){
            if(node.left != null){
                childNodes.add(node.left);
            }
            if(node.right != null){
                childNodes.add(node.right);
            }
        }
        levelNodes = childNodes;
        childNodes = new ArrayList<TreeNode>();
        }
     return true;   
    }
    
}