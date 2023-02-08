class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        dfs(0,adj,vis);
        return res;
    }
    public void dfs(int start,ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        vis[start]=true;
        res.add(start);
        for(int neig:adj.get(start))
        {
            if(!vis[neig])
                dfs(neig,adj,vis);
        }
    }
}
