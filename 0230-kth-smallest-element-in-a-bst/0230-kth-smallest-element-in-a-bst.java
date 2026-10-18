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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // 1. Go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // 2. Pop the leftmost node (smallest available)
            curr = stack.pop();
            
            // 3. Decrement k; if k reaches 0, we found our element
            k--;
            if (k == 0) {
                return curr.val;
            }
            
            // 4. Move to the right subtree
            curr = curr.right;
        }
        
        return -1; // Fallback, though a valid BST with kth element will always return inside the loop
    }
}