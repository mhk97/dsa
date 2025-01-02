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

    public TreeNode solve(TreeNode node, int p, int q) {
        if (node == null) return null;

        TreeNode left = solve(node.left, p, q);
        TreeNode right = solve(node.right, p, q);

        if (node.val == p || node.val == q) return node;

        if (left != null && right != null) return node;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
