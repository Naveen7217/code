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
    List<Integer> arr = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
        {
            return 0;
        }
        traverse(root,low,high,arr);
        int sum=0;
        for(int i=0;i<arr.size();i++)
        {
            sum+=arr.get(i);
        }
        return sum;  
        
    }
    public void traverse(TreeNode root,int low,int high,List<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        if(root.val>=low && root.val<=high)
        {
            arr.add(root.val);
        }
        traverse(root.left,low,high,arr);
        traverse(root.right,low,high,arr);
    }
}
