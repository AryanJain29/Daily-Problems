//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        Queue<Integer> pNum = new LinkedList<Integer>();
        Queue<Integer> nNum = new LinkedList<Integer>();
        for(Integer i : arr)
        {
            if(i >= 0)
            {
                pNum.add(i);
            }
            else
            {
                nNum.add(i);
            }
        }
        arr.clear(); // clear all the elements of arr
        while(!pNum.isEmpty() || !nNum.isEmpty())
        {
            if(!pNum.isEmpty())
            {
                Integer ele = pNum.poll(); 
                arr.add(ele);
            }
            if(!nNum.isEmpty())
            {
                Integer ele = nNum.poll();
                arr.add(ele);
            }
        }
    }
}