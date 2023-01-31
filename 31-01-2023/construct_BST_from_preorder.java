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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode res = bst(preorder,Integer.MAX_VALUE);
        return res;
    }
    public TreeNode bst(int[] order,int val)
    {
        if(i==order.length || order[i]>val)
        {
            return null;
        }
        TreeNode root = new TreeNode(order[i++]);
        root.left = bst(order,root.val);
        root.right = bst(order,val);
        return root;
    }
}
