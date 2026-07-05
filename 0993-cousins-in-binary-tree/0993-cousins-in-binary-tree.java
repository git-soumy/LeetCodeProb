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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode parentX = null;
        TreeNode parentY = null;

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (node.left.val == x) {
                        parentX = node;
                    }
                    if (node.left.val == y) {
                        parentY = node;
                    }
                    q.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        parentX = node;
                    }
                    if (node.right.val == y) {
                        parentY = node;
                    }
                    q.offer(node.right);
                }
            }
            if (parentX != null && parentY != null) {
                return parentX != parentY;
            }
            if (parentX != null || parentY != null) {
                return false;
            }
        }
        return false;
    }
}