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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=0;
        while(!queue.isEmpty())
        {
            List<Integer> row = new LinkedList<>();
            int len = queue.size();
            for(int j=1;j<=len;j++){
                if(i%2==0)
                {
                    TreeNode curr = queue.poll();
                    row.add(curr.val);
                    if(curr.left!=null)
                    {
                        queue.offer(curr.left);
                    }
                    if(curr.right!=null){
                        queue.offer(curr.right);
                    }
                }
                else
                {
                    TreeNode curr = queue.poll();
                    row.add(0, curr.val);
                    
                    if(curr.left!=null){
                        queue.offer(curr.left);
                    }
                    if(curr.right!=null)
                    {
                        queue.offer(curr.right);
                    }
                }

            }
            i++;
            res.add(row);
        }
        return res;
    }
}
