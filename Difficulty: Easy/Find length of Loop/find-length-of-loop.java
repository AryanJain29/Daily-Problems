//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);

            Solution ob = new Solution();
            System.out.println(ob.countNodesinLoop(head));
        }
    }
}

// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution

{

    //Function to find the length of a loop in the linked list.

    static int countNodesinLoop(Node head)

    {

        //Add your code here.

        int ans=1;

        Node temp=head;

        Node curr=null;

        

        while(temp!=null){

            if(temp.data<0){

                temp.data=-(temp.data);

                 curr=temp;

 

                break;

            }

            temp.data=-(temp.data);

            temp=temp.next;

        }

     if(temp!=null){

        Node slow=curr.next;

        while( slow.next!=null){

            if(slow.data<0){

                ans+=1;

                

            }

            if(slow==curr){

                break;

            }

            slow=slow.next;

        }

        return ans;

     }

      

        else{

        

        return 0;

        }

    }

}

 