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
    int min = Integer.MAX_VALUE;
    TreeNode t = null;
    public int minDiffInBST(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        inorder(root);
        return min;
        
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        if(t!=null)
        {
            min = Math.min(min,Math.abs(root.val-t.val));
        }
        t=root;
        inorder(root.right);

    }
}
