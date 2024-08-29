//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


class Solution {

    // Helper function to calculate the number of days needed with a given capacity
    private int findDays(int[] weights, int cap) {
        int days = 1, load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + load > cap) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days;
    }

    // Function to find the least weight capacity to ship all packages within D days
    public int leastWeightCapacity(int[] weights, int n, int d) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
// User function Template for Java
