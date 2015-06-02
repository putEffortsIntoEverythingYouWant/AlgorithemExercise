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
 in order travel(takes a lot space if tree is very big)..
 or define min and max
 */
 public class Solution{
     public boolean isValidBST(TreeNode root) {

         return compareWithMaxAndMin(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
         
     }
     public boolean compareWithMaxAndMin(TreeNode node, int min, int max){
         if(node ==null){
             return true;
         }

         int value = node.val;
         //very important, otherwise, value+-1 will go out of range
         if(value==Integer.MAX_VALUE && node.right!=null)return false;
         if(value==Integer.MIN_VALUE && node.left!=null)return false;
         //allow equal while passing vallue+-1 to subtree check 
         //this way, it will check single node with MAX/MIN value case correctly
         if(value<min || value>max){
             return false;
         }
         boolean left = compareWithMaxAndMin(node.left,min,value-1);
         boolean right = compareWithMaxAndMin(node.right,value+1,max);
         if(!left || !right){
             return false;
         }
         return true;
     }
 }

 /*
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        inOrderTraversal(values,root);
        for( int i=0; i<values.size()-1;i++){
            if(values.get(i+1)<=values.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public void inOrderTraversal(List<Integer> values, TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            inOrderTraversal(values,node.left);
        }
        values.add(node.val);
        if(node.right!=null){
            inOrderTraversal(values,node.right);
        }
    }
}
*/
