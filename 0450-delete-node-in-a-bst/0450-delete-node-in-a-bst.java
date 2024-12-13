/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;
        while(root!=null){
            if(root.val > key){
                //left
                if(root.left!=null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }   
            else{
                //right
                if(root.right!=null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }

        return dummy;
    }

    public TreeNode helper(TreeNode node){
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;

        TreeNode right = node.right;
        TreeNode rightMostOnLeft = find(node.left);
        rightMostOnLeft.right = right;
        return node.left;
    }

    public TreeNode find(TreeNode root){
        if(root.right == null) return root;
        return find(root.right);
    }
}