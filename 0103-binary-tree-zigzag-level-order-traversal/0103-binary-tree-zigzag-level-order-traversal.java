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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList();
        LinkedList<Integer> level = new LinkedList();

        q.add(root);
        q.add(null);

        int flag = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                if (flag == 0) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            } else {
                if (!q.isEmpty()) q.add(null);
                res.add(level);
                flag = 1 - flag;
                level = new LinkedList();
            }
        }

        return res;
    }
}
