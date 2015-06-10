/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        List<String> nums = new ArrayList<String>();
        generateNum(root,builder,nums);
        int result = 0;
        for(String num: nums){
            int current = Integer.parseInt(num);
            result+=current;
        }
        return result;
    }
    
    public void generateNum(TreeNode node, StringBuilder builder, List<String> nums){
        builder.append(node.val);
        if(node.left==null && node.right==null){
            nums.add(builder.toString());
        }
        if(node.left!=null){
            generateNum(node.left,builder,nums);
        }
        if(node.right!=null){
            generateNum(node.right,builder,nums);
        }
        builder.setLength(builder.length()-1);
    }
    
}