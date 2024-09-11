//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        ArrayList<Long>ls = new ArrayList<>();
        for(long a : arr){
            pq.add(a);
        }
        
        while(pq.size()>1){
            long n = pq.poll() + pq.poll();
            
            ls.add(n);
            pq.add(n);
        }
        
        long ans = 0;
        
        for(int i = 0; i<ls.size(); i++){
            ans += ls.get(i);
        }
        return ans;
    }
}