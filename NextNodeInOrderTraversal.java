/*
next node in order traversal
*/
/*
if has right child, the left most node of right subtree
otherwise, go up to check parent level till find a parent node that the target is in left subtree of that parent node
*/
public TreeNode nextNode(TreeNode node){
	 if(root == null){
	 	return null;
	 }
	 if(node.right!=null){
	  return findLeftMost(node.right);
	 }else{
	 	return findRightParent(node);
	 }

}

private TreeNode findLeftMost(TreeNode node){
	TreeNode target = node;
	while(target.left !=null){
		target = target.left;
	}
	return target;
}
private TreeNode findRightParent(TreeNode node){
	TreeNode parent = node.parent;
	TreeNode current = node;
	while(parent!=null){
		if(parent.left == current){
			break;
		}
		current = parent;
		parent = parent.parent;
	}
	return parent;
}