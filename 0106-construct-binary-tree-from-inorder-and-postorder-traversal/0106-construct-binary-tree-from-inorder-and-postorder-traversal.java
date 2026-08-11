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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        return build(postorder,inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int[] inorder,int left, int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int index = left;

        while(inorder[index] != root.val){
        index++;
    }


    root.right = build(postorder,inorder,index + 1,right);
    root.left = build(postorder,inorder,left, index - 1);
    return root;
    }
}