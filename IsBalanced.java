/*
implement a function to check if a binary tree is balanced such that the heights of the two subtrees of any node never differ by more than one
*/

/*
for child nodes of each node,if qualified, return real height, if not, return -1; if -1, return -1
*/

public boolean isBalanced(TreeNode node){
	if(calHeight(node) == -1){
	return false;
	}
	return true;
}
public int calHeight(TreeNode node){
	if(node == null){
	return 0;
	}
	int leftHeight = calHeight(node.left);
	int rightHeight = calHeight(node.right);
	if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1){
		return -1;
	}
	return Math.max(leftHeight,rightHeight)+1;
}
//the method above traverse both left subtree and right subtree
//to improve efficiency, we can check if the leftHeight == -1 right after calculating left subtree height. this way, if the leftHeight == -1, we don't need to traverse right subtree at all