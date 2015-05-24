/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* just pick the mid point
*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int [] nums, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode middle = new TreeNode(nums[mid]);
        middle.left = construct(nums,start,mid-1);
        middle.right = construct(nums,mid+1,end);
        
        return middle;
    }
}