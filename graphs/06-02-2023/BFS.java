class Solution {
    // Function to return Breadth First Traversal of given graph.
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        bfs(V,0,adj);
        return res;
        
    }
    public void bfs(int v,int start,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        visited[start]=true;
        q.offer(start);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            res.add(curr);
            for(int neighbour: adj.get(curr))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }
    }
}
