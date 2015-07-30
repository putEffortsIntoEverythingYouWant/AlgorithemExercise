/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        boolean reverse = false;
        List<TreeNode> parent = new ArrayList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()){
            List<TreeNode> child = new ArrayList<TreeNode>();
            List<Integer> valueSet = new ArrayList<Integer>();
            for(TreeNode current: parent){
                if(current.left!=null){
                    child.add(current.left);
                }
                if(current.right!=null){
                    child.add(current.right);
                }
                valueSet.add(current.val);
            }
            if(reverse){
                int start = 0;
                int end = valueSet.size()-1;
                while(start<end){
                    int temp = valueSet.get(start);
                    valueSet.set(start,valueSet.get(end));
                    valueSet.set(end,temp);
                    start++;
                    end--;
                }
                reverse = false;
            }else{
                reverse = true;
            }
            result.add(valueSet);
            parent = child;
        }
        return result;
    }
}