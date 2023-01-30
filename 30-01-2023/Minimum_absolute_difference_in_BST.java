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
 import java.util.*;
class Solution {
    List<Integer> res = new LinkedList<>();
    public int getMinimumDifference(TreeNode root) {
        traverse(root,res);
        int min = Math.abs(res.get(0)-res.get(1));
        for(int i=0;i<res.size()-1;i++)
        {
            if(Math.abs(res.get(i)-res.get(i+1))<min)
            {
                min = Math.abs(res.get(i)-res.get(i+1));
            }

        }
        return min;
        
    }
    public void traverse(TreeNode t,List<Integer> arr)
    {
        if(t==null)
        {
            return;
        }
        traverse(t.left,arr);
        arr.add(t.val);
        traverse(t.right,arr);
    }
}
