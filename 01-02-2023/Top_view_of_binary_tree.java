import java.util.* ;
import java.io.*; 
import javafx.util.Pair;
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/

public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
		ArrayList<Integer> res = new ArrayList<>();
		if(root==null)
		{
			return res;
		}
		Map<Integer,Integer> map = new TreeMap<>();
		Queue<Pair<BinaryTreeNode,Integer>> q = new LinkedList<>();
		q.offer(new Pair(root,0));
		while(!q.isEmpty())
		{
			Pair temp = q.poll();
			BinaryTreeNode curr = (BinaryTreeNode)temp.getKey();
			int hd = (int)temp.getValue();
			if(map.get(hd)==null)
			{
				map.put(hd,curr.val);
			}
			if(curr.left!=null)
			{
				q.offer(new Pair(curr.left,hd-1));
			}
			if(curr.right!=null)
			{
				q.offer(new Pair(curr.right,hd+1));
			}
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			res.add(entry.getValue());
		}
		return res;
	}
}
