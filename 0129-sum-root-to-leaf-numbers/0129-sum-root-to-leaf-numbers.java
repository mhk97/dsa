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
    int res = 0;

    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return res;
    }

    public void solve(TreeNode node, int curr) {
        if (node == null) return ;

        curr = curr * 10 + node.val;

        if (node.left == null && node.right == null) {
            res += curr;
            return;
        }

        solve(node.left, curr);
        solve(node.right, curr);
    }
}
