//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends



class Solution
{
	public int minOperations(String s1, String s2) 
	{ 
	    // Your code goes here
	    int x = s1.length(), y = s2.length();
	    int[] dp = new int[y+1];
        
        for(int i=1; i<=x; i++){ // L.C.S
            int[] curr = new int[y+1];
            for(int j=1; j<=y; j++){
                
                   if(s1.charAt(i-1) == s2.charAt(j-1)) curr[j] = 1 + dp[j-1];
                   else curr[j] = Math.max(dp[j],curr[j-1]);
                }
            dp = curr;
        }
        // Formula to get total_operations ~
        // del = x - lcs, ins = y - lcs i.e total_op = x + y - 2 * lcs
        return (x + y - 2 * dp[y]);
	} 
}