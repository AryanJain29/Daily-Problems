/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Base case: if the list is empty or has only one element, return the head as is
        if (head == null || head.next == null) {
            return head;
        }

        // Insert the GCD node recursively
        ListNode temp = insertGreatestCommonDivisors(head.next);

        // Create a new node with the GCD of current and next node values
        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));
        
        // Insert the new node between current node and next node
        gcdNode.next = temp;
        head.next = gcdNode;

        return head;
    }
}