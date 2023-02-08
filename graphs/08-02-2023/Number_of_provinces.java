class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        int col = isConnected[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++)
        {
            res.add(new ArrayList<>());
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    res.get(i).add(j);
                    res.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[row];
        int count=0;
        for(int i=0;i<row;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,res,visited);
            }
        }
        return count;

        
    }
    public void dfs(int start,List<List<Integer>> adj,boolean[] visited)
    {
        visited[start]=true;
        for(int neigh:adj.get(start))
        {
            if(!visited[neigh])
            {
                dfs(neigh,adj,visited);
            }
        }
    }
}
