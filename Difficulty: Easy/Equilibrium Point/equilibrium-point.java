//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            long[] arr = new long[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.equilibriumPoint(arr));
        }
    }
}

// } Driver Code Ends

class Solution {
   public static int equilibriumPoint(long arr[]) {
        // Your code here
        if(arr.length==1)return 1;
        if(arr.length==2){
            if(arr[0]>arr[1])return 1;
            else return 2;
        }
        long ts=0;
        long rs=0;
        long ls=0;
        for(int i=0;i<arr.length;i++){
            ts+=arr[i];
        }
        for(int i=0;i<arr.length-1;i++){
            rs+=arr[i];
            ls=ts-rs-arr[i+1];
            if(rs==ls)return i+1+1;
        }
        return -1;
    }//function
}//class