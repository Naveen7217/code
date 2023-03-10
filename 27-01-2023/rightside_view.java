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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
        {
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int len = queue.size();
            for(int i=1;i<=len;i++)
            {
                TreeNode temp = queue.poll();
                if(i==len)
                {
                    res.add(temp.val);
                }
                if(temp.left!=null)
                {
                    queue.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.offer(temp.right);
                }
            }
            
        }
        return res;


    }
    
}
