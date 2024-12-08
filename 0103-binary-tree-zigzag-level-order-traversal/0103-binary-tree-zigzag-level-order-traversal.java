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
        q.add(root);
        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                temp.add(node.val);
            }

            if (flag == 0) {
                res.add(temp);
            } else {
                Collections.reverse(temp);
                res.add(temp);
            }

            flag = 1 - flag;
        }

        return res;
    }
}
