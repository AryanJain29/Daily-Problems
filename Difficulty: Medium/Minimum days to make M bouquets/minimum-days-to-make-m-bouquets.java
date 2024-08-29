//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {


    static boolean isPossible(int arr[],int flower,int days,int mid){
        int count=0;
        int countB=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }
           else{
           count = count - (count% days);
           }
        }
          count = count / days;
      
      return count>=flower;
    }

    public static int solve(int M, int K, int[] bloomDay) {
       
       long val=(long) M * K;
      if((val) > bloomDay.length){
          return -1;
      } 
      int ans=-1;
      int low=Integer.MAX_VALUE;
      int high=Integer.MIN_VALUE;
      for(int i=0;i<bloomDay.length;i++){
          low=Math.min(low,bloomDay[i]);
          high=Math.max(high,bloomDay[i]);
      }
      while(low<=high){
          int  mid=low + (high-low) / 2 ;
          if(isPossible(bloomDay,M,K,mid)){
              ans=  mid;
              high=mid-1;
          }
          else{
              low=mid+1;
          }
      }
       return ans;
       
    }
}