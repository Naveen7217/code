class Solution {
    public boolean isBipartite(int[][] graph) {
        int row = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<row;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[row+1];
        Arrays.fill(color,-1);
        for(int i=0;i<row;i++)
        {
            if(color[i]==-1)
            {
                if(check(i,adj,color)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(int id,List<List<Integer>> adj,int[] color)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        color[id]=0;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int neigh:adj.get(curr))
            {
                if(color[neigh]==-1)
                {
                    color[neigh]=1-color[curr];
                    q.offer(neigh);
                }
                if(color[neigh]==color[curr])
                {
                    return false;
                }
            }
        }
        return true;

    }
}
