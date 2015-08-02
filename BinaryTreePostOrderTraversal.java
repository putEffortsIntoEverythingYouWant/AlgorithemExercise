/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        //if left child ==null and right child ==null, pop
        //if last visited is left node or right node of current visit node, pop
        //else push right, push left
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode lastVisited = null;
        while(!stack.empty()){
            TreeNode current = stack.peek();
            if(current.left==null && current.right==null){
                 lastVisited = current;
                result.add(stack.pop().val);
               
            }else if(lastVisited != null && (lastVisited==current.left || lastVisited == current.right)){
                lastVisited = current;
                result.add(stack.pop().val);
            }else{
                if(current.right!=null){
                    stack.push(current.right);
                }
                if(current.left!=null){
                    stack.push(current.left);
                }
            }
        }
        return result;
    }
}