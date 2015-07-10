/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
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
//O(n)
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!stack.empty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode pop = stack.pop();
                p=pop.right;
                count++;
                if(count==k){
                    return pop.val;
                }
            }
        }
        return 0;
    }
}