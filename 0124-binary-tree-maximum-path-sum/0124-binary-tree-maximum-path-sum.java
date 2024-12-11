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

    public int maxPathSum(TreeNode root) {
        solve(root);

        return res;
    }

    int res = Integer.MIN_VALUE;

    public int solve(TreeNode root) {
        if (root == null) return (int) -1e9;

        int left = solve(root.left);
        int right = solve(root.right);

        int val = Math.max(root.val, root.val + Math.max(left, right));

        res = Math.max(res, Math.max(val, left + right + root.val));

        return val;
    }
}
