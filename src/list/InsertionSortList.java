package list;

/**
 * @ClassName InsertionSortList
 * @Description TODO
 * @Author katefu
 * @Date 4/9/23 11:42 PM
 * @Version 1.0
 **/
public class InsertionSortList {
    public static void main(String[] args) {
        Solution147 test = new Solution147();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        test.insertionSortList(n1);
    }
}


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
class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode preInsert, toInsert, dummyHead = new ListNode(0);
        dummyHead.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
            } else {
                toInsert = head.next;
                // Locate preInsert.
                preInsert = dummyHead;
                while (preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                head.next = toInsert.next;
                // Insert toInsert after preInsert.
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }

        return dummyHead.next;
    }
}