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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) return new ArrayList();

        Map<TreeNode, TreeNode> map = new HashMap();
        inorder(map, root);
        map.put(root, null);

        Queue<TreeNode> q = new LinkedList();

        q.add(target);

        List<Integer> res = new ArrayList();
        Set<TreeNode> set = new HashSet();

        while (!q.isEmpty() && k > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                set.add(curr);
                if (curr.left != null && !set.contains(curr.left)) q.add(curr.left);
                if (curr.right != null && !set.contains(curr.right)) q.add(curr.right);
                if (map.get(curr) != null && !set.contains(map.get(curr))) q.add(map.get(curr));
            }

            k--;
        }

        while (!q.isEmpty()) res.add(q.poll().val);

        return res;
    }

    public void inorder(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            map.put(root.left, root);
        }

        inorder(map, root.left);

        if (root.right != null) {
            map.put(root.right, root);
        }

        inorder(map, root.right);
    }
}
