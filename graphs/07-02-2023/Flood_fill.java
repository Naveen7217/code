class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] res = image;
        int icolor = image[sr][sc];
         int delrow[] = {-1,1,0,0};
         int delcol[] = {0,0,1,-1};
         dfs(image,sr,sc,color,icolor,res,delrow,delcol);
         return res;
        
    }
    public void dfs(int[][] image,int sr,int sc,int color,int icolor,int[][] res,int[] delrow,int[] delcol)
    {
        res[sr][sc]=color;
        int row = image.length;
        int col = image[0].length;

        for(int i=0;i<delrow.length;i++)
        {
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && image[nrow][ncol]==icolor && res[nrow][ncol]!=color)
            {
                dfs(image,nrow,ncol,color,icolor,res,delrow,delcol);
            }
        }
    }
}
