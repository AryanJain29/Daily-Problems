//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        List<List<Integer>> graph = new ArrayList<>(K);
        
        for (int i = 0; i < K; i++) {
             graph.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < N-1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            
            int len = Math.min(word1.length(), word2.length());

            
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a'; // cal the index
                    int to = word2.charAt(j) - 'a';
                    graph.get(from).add(to);
                    break;

                }
            }
        }
        
        boolean[] visited = new boolean[K];
        boolean[] recStack = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
               if (topologicalSort(i, graph, visited, recStack, stack)) {
                  return ""; 
                }
            }
        }
        
        
        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            order.append((char) (stack.pop() + 'a'));
        }
        
        return order.toString();
    
        
    }
    
    private boolean topologicalSort(int v, List<List<Integer>> graph, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
        visited[v] = true;
        recStack[v] = true;
        
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                if (topologicalSort(neighbor, graph, visited, recStack, stack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // cycle detected
            }
        }
        recStack[v] = false;
        stack.push(v);
        return false;
    }
}