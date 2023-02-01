/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> solve(TreeNode A, int B) {
        boolean res1 = traverse(A,B,res);
        return res;
    }
    public boolean traverse(TreeNode root,int data,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return false;
        }
        arr.add(root.val);
        if(root.val==data)
        {
            return true;
        }
        if(traverse(root.left,data,arr) || traverse(root.right,data,arr))
        {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
}
