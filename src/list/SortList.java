package list;

/**
 * @ClassName SortList
 * @Description TODO
 * @Author katefu
 * @Date 7/13/22 10:19 AM
 * @Version 1.0
 **/
public class SortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution148 test = new Solution148();
        test.sortList(n1);
    }
}

class Solution148 {
    // time limit exceed
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-100001);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        boolean isSwapped = true;
        while(true){
            if(!isSwapped) break;
            isSwapped = false;
            pre = dummy;
            cur = pre.next;

            while(cur.next!=null){
                if(cur.val>cur.next.val){
                    pre.next = cur.next;
                    cur.next = pre.next.next;
                    pre.next.next = cur;
                    isSwapped = true;
                    pre = pre.next;
                }else{
                    cur = cur.next;
                    pre = pre.next;
                }


            }
        }

        return dummy.next;
    }

    //merge sort
    public ListNode sortListSample(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}