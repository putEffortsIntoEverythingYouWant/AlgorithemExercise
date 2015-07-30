/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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

public class BSTIterator {
    Stack<TreeNode> stack ;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if(root!=null){
            stack.push(root);
        }
        while(!stack.empty()){
            if(stack.peek().left!=null){
                stack.push(stack.peek().left);
            }else{
                break;
            }
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode smallest = stack.pop();
        if(smallest.right!=null){
            stack.push(smallest.right);
            while(!stack.empty()){
                if(stack.peek().left!=null){
                    stack.push(stack.peek().left);
                }else{
                    break;
                }
            }
        }
        return smallest.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */