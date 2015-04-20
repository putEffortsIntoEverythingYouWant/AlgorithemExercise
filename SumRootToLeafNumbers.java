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
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 this question comes with an assumption that all nums are within Integer range
 and all positive
 remember to return on leaf node (otherwise {9} will added up tp 18 )and remove the last appened val from stringbuilder
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<String> nums = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        track(root,nums,builder);
        int result = Integer.parseInt(nums.get(0));
        for(int i=1; i<nums.size(); i++){
            result = result+Integer.parseInt(nums.get(i));
        }
        return result;
        
    }
    
    public void track(TreeNode root, List<String> nums,StringBuilder builder)
    {

        builder.append(root.val);
        if(root.left==null && root.right==null){
            nums.add(builder.toString());
            builder.setLength(builder.length()-1);
            return;
        }
        if(root.left!=null){
            track(root.left,nums,builder);
        }
        if(root.right!=null){
         track(root.right,nums,builder);
        }
        builder.setLength(builder.length()-1);
        
    }
}