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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make circular list
        tail.next = head;

        // Reduce k
        k = k % length;

        // Find new tail
        int steps = length - k;

        ListNode newTail = tail;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }

        // New head
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}