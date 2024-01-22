package list;

/**
 * @ClassName ReorderList
 * @Description TODO
 * @Author katefu
 * @Date 9/11/22 4:11 PM
 * @Version 1.0
 **/
import java.util.*;

public class ReorderList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        reorderList(n1);


        reorderList2(n1);
        ListNode cur = n1;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    static ListNode reorderList(ListNode head) {
// WRITE YOUR CODE HERE
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!=null && fast.next!=null){
            fast = fast.next.next;;
            slow = slow.next;
        }

        ListNode rightHead = reverseList(slow.next);
        ListNode leftHead = head;

        mergeList(leftHead, rightHead);

        return head;
    }

    static ListNode reverseList(ListNode head){
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode aft = cur.next;
            cur.next = pre;
            pre = cur;
            cur = aft;
        }
        return pre;
    }

    static void mergeList(ListNode left, ListNode right){
        //left length >= right length
        if(left==null && right==null) return;
        while(right!=null){
            ListNode next = left.next;
            left.next = right;
            left = right;
            right = next;
        }
    }

    public static void reorderList2(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow: 3, fast: 5
        // reverse slow to fast: 345 -> 543
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second!=null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // two pointers
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}