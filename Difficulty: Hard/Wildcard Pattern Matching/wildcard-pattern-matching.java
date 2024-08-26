//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    Boolean dp[][];
    public int wildCard(String pattern, String str) {
        int n=pattern.length(), m=str.length();
        dp = new Boolean[n][m];
        return solve(0,0,n,m,pattern,str)?1:0;
    }
    boolean solve(int i,int j,int n,int m,String p,String s){
        if(j==m){
            for(int k=i;k<n;k++)    if(p.charAt(k)!='*')    return false;
            return true;
        }
        if(i==n)    return false;
        
        if(dp[i][j]!=null)  return dp[i][j];
        
        if(p.charAt(i)==s.charAt(j))    return dp[i][j]=solve(i+1,j+1,n,m,p,s);
        else if(p.charAt(i)=='?') return dp[i][j]=solve(i+1,j+1,n,m,p,s);
        else if(p.charAt(i)=='*')   return dp[i][j]=solve(i,j+1,n,m,p,s) || solve(i+1,j,n,m,p,s);
        
        return false;
    }
}