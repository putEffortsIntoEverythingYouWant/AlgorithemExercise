/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
/*
same thing as generate BST with minimum height, just instead of return
a node, return a list;
make sure the children trees are combination not in order matching
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> parentList = new ArrayList<TreeNode>();
        if(start>end){
            parentList.add(null);
            return parentList;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftChilds = generate(start,i-1);
            List<TreeNode> rightChilds = generate(i+1,end);
            generateChildTrees(i, leftChilds, rightChilds, parentList);
        }
        return parentList;
        
    }
    public void generateChildTrees(int currentValue, List<TreeNode> leftChilds, List<TreeNode> rightChilds, List<TreeNode> results){
        //need to make new instance of each combination of subtrees
        int leftSize = leftChilds.size();
        int rightSize = rightChilds.size();
        for(int i=0; i<leftSize; i++){
            for(int j=0; j<rightSize; j++){
                TreeNode parent = new TreeNode(currentValue);
                parent.left = leftChilds.get(i);
                parent.right = rightChilds.get(j);
                results.add(parent);
            }
        }
    }
}