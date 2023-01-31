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
    List<Integer> res = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        TreeNode t = bst(res,0,res.size()-1);
        return t;
        
    }
    public TreeNode bst(List<Integer> arr,int low,int high)
    {
        if(low>high)
        {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = bst(arr,low,mid-1);
        root.right = bst(arr,mid+1,high);
        return root;
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);

    }
}
