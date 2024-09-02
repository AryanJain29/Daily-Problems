//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to return the minimum cost to react at bottom
    //right cell from top left cell.
    class tuple implements Comparable<tuple>
    {
        int dist ; 
        int row ;
        int col;
        tuple(int dist , int row , int col)
        {
            this.dist = dist;
            this.col = col;
            this.row = row;
        }
        public int compareTo(tuple that)
        {
            return this.dist - that.dist;
        }
    }
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        for(int i =0 ; i < n ; i++)
        {
            for(int j =0 ; j < m ; j++)
            {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        PriorityQueue<tuple> qu = new PriorityQueue<>();
        qu.offer(new tuple(grid[0][0] , 0 , 0));
        int drow[] = {-1 , 0 , 1 , 0};
        int dcol[] = {0 ,1, 0 , -1};
        while(qu.size()>0)
        {
            tuple curr = qu.poll();
            int curr_dist = curr.dist;
            int curr_row = curr.row;
            int curr_col = curr.col;
            for(int i =0 ; i < 4 ; i++)
            {
                int r = curr_row+drow[i];
                int c = curr_col+dcol[i];
                if(r>=0 && r<n && c>=0 && c<m && curr_dist+grid[r][c]<dis[r][c] )
                {
                    dis[r][c] = curr_dist+grid[r][c];
                    qu.offer(new tuple(dis[r][c] , r, c));
                }
            }
        }
        
        return dis[n-1][m-1];
        
    }
}