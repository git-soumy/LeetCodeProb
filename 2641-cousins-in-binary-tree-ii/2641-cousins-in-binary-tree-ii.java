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
import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // Store sum of every level
        List<Integer> levelSum = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // ---------- First BFS : Calculate level sums ----------
        while (!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            levelSum.add(sum);
        }

        // ---------- Second BFS : Replace values ----------
        root.val = 0;

        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                int siblingSum = 0;

                if (node.left != null)
                    siblingSum += node.left.val;

                if (node.right != null)
                    siblingSum += node.right.val;

                if (node.left != null) {
                    node.left.val = levelSum.get(level + 1) - siblingSum;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = levelSum.get(level + 1) - siblingSum;
                    queue.offer(node.right);
                }
            }

            level++;
        }

        return root;
    }
}