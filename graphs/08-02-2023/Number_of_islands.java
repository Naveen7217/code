class Pair{
    int row;
    int col;
    Pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int visited[][] = new int[row][col];
        int count=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
        
    }
    public void bfs(int row,int col,char[][] grid,int visited[][])
    {
        visited[row][col]=1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int nthrow = curr.row;
            int nthcol = curr.col;

            for(int i=0;i<4;i++)
            {
                int delerow = nthrow + delrow[i];
                int delecol = nthcol + delcol[i];

                if(delerow>=0 && delerow<n && delecol>=0 && delecol<m && visited[delerow][delecol]==0 && grid[delerow][delecol]=='1')
                {
                    visited[delerow][delecol]=1;
                    bfs(delerow,delecol,grid,visited);
                }
            }
        }

    }
}
