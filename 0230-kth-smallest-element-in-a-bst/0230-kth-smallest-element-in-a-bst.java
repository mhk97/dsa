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
    int res, k;

    public int kthSmallest(TreeNode root, int k) {
        res = -1;
        this.k = k;

        solve(root);

        return res;
    }

    public void solve(TreeNode curr) {
        if (curr == null) return;
        solve(curr.left);

        k--;
        if (k == 0 && res == -1) {
            res = curr.val;
            return;
        }

        solve(curr.right);
    }
}
