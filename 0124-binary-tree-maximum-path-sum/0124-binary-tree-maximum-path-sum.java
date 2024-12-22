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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;

        // if (root.left == null && root.right == null) return root.val;

        int left = solve(root.left);
        int right = solve(root.right);

        int first = left + right + root.val;
        int second = Math.max(left, right) + root.val;
        int third = root.val;

        max = Math.max(max, Math.max(third, Math.max(first, second)));

        return Math.max(second, third);
    }
}
