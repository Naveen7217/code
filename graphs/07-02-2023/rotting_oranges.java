class Pair{
    int row;
    int col;
    int step;
    public Pair(int row,int col,int step)
    {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh_orange = 0;
        int[][] visited = new int[row][col];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                if(grid[i][j]==1)
                {
                    fresh_orange++;
                }
                else
                {
                    visited[i][j]=0;
                }
                
            }
        }
        int step=0;
        int count=0;
        int delrow[]={-1,1,0,0};
        int delcol[]={0,0,1,-1};
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int Row = curr.row;
            int Col = curr.col;
            int st = curr.step;
            step = Math.max(step,st);
            for(int i=0;i<delrow.length;i++)
            {
                int newrow = Row+delrow[i];
                int newcol = Col + delcol[i];
                if(newrow>=0 && newrow<row && newcol>=0 && newcol<col && visited[newrow][newcol]==0 && grid[newrow][newcol]==1)
                {
                    q.offer(new Pair(newrow,newcol,st+1));
                    visited[newrow][newcol]=2;
                    count++;
                }
            }
        }
        if(count==fresh_orange)
        {
            return step;
        }
        return -1;
        
    }
}
