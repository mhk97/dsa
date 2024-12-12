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

    public boolean isValidBST(TreeNode root) {
        return solve(root, null, null);
    }

    public boolean solve(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;

        if ((low!= null && root.val <= low) ||
         (high != null && root.val >= high)) return false;

        boolean left = solve(root.left, low, root.val);
        boolean right = solve(root.right, root.val, high);

        return left && right;
    }
}
