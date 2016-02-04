/*
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.
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
class Solution {
    
    public static int pointer = 0;
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        //pre order traversal
        preorder(root,buffer);
        return buffer.toString();
        
    }
    public void preorder(TreeNode root, StringBuffer buffer){
        if(root==null){
            buffer.append("#").append(",");
            return;
        }
        buffer.append(root.val).append(",");
        preorder(root.left,buffer);
        preorder(root.right,buffer);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data==null || data.isEmpty()){
            return null;
        }
        String [] elements = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        pointer = 1;
        buildTree(root,elements);
        return root;
    }
    public void buildTree(TreeNode node, String [] elements){

	        if(!elements[pointer].equals("#")){
	            node.left = new TreeNode(Integer.parseInt(elements[pointer]));
		        pointer++;
		        buildTree(node.left,elements);
	        }else{
	        	pointer++;
	        }

	        if(!elements[pointer].equals("#")){
	            node.right = new TreeNode(Integer.parseInt(elements[pointer]));
	            pointer++;
		        buildTree(node.right,elements);
	        }else{
	        	pointer++;
	        }
    }   
}
