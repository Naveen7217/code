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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> imap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            imap.put(inorder[i],i);
        }
        TreeNode root = construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1,imap);
        return root;
        
    }
    public TreeNode construct(int[] porder,int pstart,int pend,int[] iorder,int istart,int iend,Map<Integer,Integer> map)
    {
        if(pstart>pend || istart>iend)
        {
            return null;
        }
        TreeNode root = new TreeNode(porder[pstart]);
        int id=map.get(root.val);
        int lft = id-istart;
        root.left = construct(porder,pstart+1,pstart+lft,iorder,istart,id-1,map);
        root.right =construct(porder,pstart+lft+1,pend,iorder,id+1,iend,map);
        return root;
    }
}
