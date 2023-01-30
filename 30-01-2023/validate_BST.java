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
    List<Integer> res = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        traverse(root,res);
        System.out.println(res);
        for(int i=0;i<res.size()-1;i++)
        {
            if(res.get(i+1)<=res.get(i))
            {
                return false;
            }
        }
        return true;  
    }
    public void traverse(TreeNode root,List<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        traverse(root.left,arr);
        arr.add(root.val);
        traverse(root.right,arr);
    }
}
