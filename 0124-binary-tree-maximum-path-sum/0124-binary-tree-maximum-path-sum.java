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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int max = Math.max(left, right);

        int sum1 = left + right + root.val;
        int sum2 = max + root.val;

        res = Math.max(res, Math.max(sum1, Math.max(sum2, root.val)));

        return Math.max(sum2, root.val);
    }
}
