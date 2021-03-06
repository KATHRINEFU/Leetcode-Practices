package list;

/**
 * @ClassName AddTwoNumbers
 * @Description
 *     You are given two non-empty linked lists representing two non-negative integers.
 *     The digits are stored in reverse order, and each of their nodes contains a single digit.
 *     Add the two numbers and return the sum as a linked list.
 *     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *     Input: l1 = [2,4,3], l2 = [5,6,4]
 *     Output: [7,0,8]
 *     Explanation: 342 + 465 = 807.
 *
 * @Author katefu
 * @Date 5/14/22 11:13 AM
 * @Version 1.0
 **/
public class AddTwoNumbers {
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}