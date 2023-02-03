/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node==null)
            {
                res.append("# ");
                continue;
            }
            res.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        System.out.print(res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
        {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] val = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.offer(root);
        for(int i=1;i<val.length;i++)
        {
            TreeNode curr = q.poll();
            if(!val[i].equals("#"))
            {
                TreeNode lef = new TreeNode(Integer.parseInt(val[i]));
                curr.left = lef;
                q.offer(lef);

            }
            if(!val[++i].equals("#"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                curr.right = right;
                q.offer(right);
            }
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
