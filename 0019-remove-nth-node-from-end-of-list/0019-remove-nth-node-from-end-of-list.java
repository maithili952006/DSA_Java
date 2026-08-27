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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node simplifies edge cases like removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 1. Move fast pointer so that the gap between fast and slow is n + 1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move both pointers until fast reaches null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 3. Skip the target node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}