//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int i=0;
        int j=arr.length-1;
        
        int Fsum=arr[i], Lsum=arr[j];
        while(i<j){
            if(Lsum==Fsum && i+1==j){
                return true;
            }
                if(Fsum>Lsum){
                    j -=1;
                    Lsum +=arr[j];
                }
                else{
                    i +=1;
                    Fsum +=arr[i];
                }
            
        }
        return false;
    }
}