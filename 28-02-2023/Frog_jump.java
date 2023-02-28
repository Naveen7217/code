import java.util.* ;
import java.io.*; 
public class Solution {

    public static int helper(int ind,int[] heights,int[] dp)
    {
        if(ind==0)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int left = Math.abs(heights[ind]-heights[ind-1])+helper(ind-1,heights,dp);
        int right = Integer.MAX_VALUE;
        if(ind>1)
        {
            right = Math.abs(heights[ind]-heights[ind-2])+helper(ind-2,heights,dp);
        }
        return dp[ind]=Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n-1,heights,dp);
        // Write your code here..
    }

}
