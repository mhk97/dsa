/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p.val, q.val);
    }

    public TreeNode solve(TreeNode root, int p, int q) {
        if(root == null) return null;
        if(p == root.val || q == root.val) return root;
        if(p < root.val && q < root.val) return solve (root.left, p, q);
        if (p > root.val && q > root.val) return solve(root.right, p, q);
        return root;
    }
}