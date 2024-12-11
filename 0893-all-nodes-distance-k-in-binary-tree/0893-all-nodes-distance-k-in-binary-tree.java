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
        Map<TreeNode, TreeNode> parent = new HashMap();
        parent.put(root, null);

        fillMap(parent, root);

        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        Set<TreeNode> set = new HashSet();
        while (!q.isEmpty() && k > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                set.add(curr);
                if (curr.left != null && !set.contains(curr.left)) q.add(curr.left);
                if (curr.right != null && !set.contains(curr.right)) q.add(curr.right);
                if (parent.get(curr) != null && !set.contains(parent.get(curr))) q.add(parent.get(curr));
            }

            k--;
        }

        List<Integer> res = new ArrayList();
        while (!q.isEmpty()) res.add(q.poll().val);
        return res;
    }

    public void fillMap(Map<TreeNode, TreeNode> parent, TreeNode root) {
        if (root == null) return;

        if (root.left != null) parent.put(root.left, root);
        fillMap(parent, root.left);

        if (root.right != null) parent.put(root.right, root);
        fillMap(parent, root.right);
    }
}
