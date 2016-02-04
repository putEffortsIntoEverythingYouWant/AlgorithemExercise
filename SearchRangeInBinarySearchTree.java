/*
search range in BST
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        search(root,result,k1,k2);
        return result;
        
    }
    //+1 -1 to better handle node.val == k1 || node.val ==k2, since bst only has distinct values
   //utilize it's own order to maintain the insertion order, let the smaller one insert first 
    public void search(TreeNode node, List<Integer> result, int k1, int k2){
        if(node==null){
            return;
        }
        if(k1>k2){
            return;
        }
        if(node.val < k1){
            search(node.right, result, k1, k2);
            return;
        }
        if(node.val > k2){
            search(node.left,result,k1,k2);
            return;
        }
        
        search(node.left, result, k1, node.val-1);
        result.add(node.val);
        search(node.right,result,node.val+1,k2);
        
    }
      //or more straight forward...
    public void search(TreeNode node, List<Integer> result, int k1, int k2){
        if(node==null){
            return;
        }
 
        if(node.val < k1){
            search(node.right, result, k1, k2);
            return;
        }
        if(node.val > k2){
            search(node.left,result,k1,k2);
            return;
        }
        
        search(node.left, result, k1, node.val);
        result.add(node.val);
        search(node.right,result,node.val,k2);
        
    }
}