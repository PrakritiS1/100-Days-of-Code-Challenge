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
    public ListNode sortList(ListNode head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle of linked list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Divide into two halves
        ListNode second = slow.next;
        slow.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // Merge both sorted lists
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }

        return dummy.next;
    }
}
