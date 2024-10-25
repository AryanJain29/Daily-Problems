//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void swap(int arr[],int i,int j)
    {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static void sort012(int a[], int n)
    {
        // code here 
       
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(a[mid]==0)
            {
                swap(a,low,mid);
                low++;
                mid++;
            }
            else if(a[mid]==1)
            {
                mid++;
            }
            else{
                swap(a,mid,high);
                high--;
            }
        }
        
    }
}




//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends