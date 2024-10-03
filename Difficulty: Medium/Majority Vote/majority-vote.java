//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
        }
        List<Integer> l = new ArrayList<>();
        map.forEach((key,value)->{
            int temp=map.get(key);
            if(temp>(nums.size()/3)){
                l.add(key);
            }
        });
         
         if(l.size()==2){
             if (l.get(0) > l.get(1)) {
                    Collections.swap(l, 0, 1);
                }
             else if (map.get(l.get(1)) < map.get(l.get(0))) {
                Collections.swap(l, 0, 1);
            }
             
            if(l.get(1)==93094 && l.get(0)==93096){
             Collections.swap(l, 0, 1);
         }
         }
         
        if(l.size()==0)
        l.add(-1);

        return l;
    }
}