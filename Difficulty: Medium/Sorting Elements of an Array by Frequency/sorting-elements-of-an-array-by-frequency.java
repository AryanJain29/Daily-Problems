//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Set<Integer> set = new HashSet<>();
        
        for(var i : arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
            set.add(i);
        }
        
        HashMap<Integer, PriorityQueue> hm2 = new HashMap<>();
        for(var i : set){
          PriorityQueue<Integer> temp = new PriorityQueue<>();      
          boolean flag = true;
          if(hm2.getOrDefault(hm.get(i),null) != null){
              temp = hm2.get(hm.get(i));
              flag = false;
          }
          if(flag)
            pq.add(hm.get(i));
          temp.add(i);
          hm2.put(hm.get(i), temp);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int n = pq.poll();
            PriorityQueue<Integer> q = hm2.get(n);
            while(!q.isEmpty()){
                int data = q.poll();
                for(int i = 0; i<n; i++)
                    res.add(data);
            }
        }
        return res;
          
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends