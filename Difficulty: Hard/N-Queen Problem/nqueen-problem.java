//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        if(solve(0,n,board,al)){
            return al;
        }
        else{
            return al;
        }
    }
    static boolean solve(int row,int n,boolean[][] board,ArrayList<ArrayList<Integer>> al)
    {
        if(row==n){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==true){
                        list.add(j+1);
                    }
                }
            }
            al.add(list);
            return true;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(row,i,n,board,al)){
                board[row][i]=true;
                solve(row+1,n,board,al);
                board[row][i]=false;
            }
        }
        return false;
    }
    static boolean isSafe(int row,int col,int n,boolean board[][],ArrayList<ArrayList<Integer>> al)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]){
                return false;
            }
        }
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row,j=col;i>=0&&j<n;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
}