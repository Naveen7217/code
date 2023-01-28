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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val,null,null);
        if(root==null)
        {
            root = node;
            return root;
        }
        TreeNode curr = root;
        TreeNode temp = null;
        while(curr!=null)
        {
            temp = curr;
            if(val<curr.val)
            {
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }
        if(val<temp.val)
        {
            temp.left = node;
        }
        else
        {
            temp.right = node;
        }
        return root;
        
    }
}
