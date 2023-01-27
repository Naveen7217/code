import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        travrse(root,res,0);
        return res;
         //    Write your code here.
    }
    public static void travrse(TreeNode<Integer> root,ArrayList<Integer> arr,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(depth==arr.size())
        {
            arr.add(root.data);
        }
        travrse(root.left,arr,depth+1);
        travrse(root.right,arr,depth+1);
    }
}
