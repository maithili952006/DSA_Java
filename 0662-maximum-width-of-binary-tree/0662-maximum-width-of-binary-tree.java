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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int maxWidth = 0;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 1L});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            long start = (long) queue.peek()[1];
            long end = start;
            
            for (int i = 0; i < size; i++) {
                Object[] curr = queue.poll();
                TreeNode node = (TreeNode) curr[0];
                long index = (long) curr[1];
                
                end = index;
                long normalized = index - start;
                
                if (node.left != null) {
                    queue.offer(new Object[]{node.left, 2 * normalized});
                }
                if (node.right != null) {
                    queue.offer(new Object[]{node.right, 2 * normalized + 1});
                }
            }
            maxWidth = Math.max(maxWidth, (int)(end - start + 1));
        }
        
        return maxWidth;
    }
}