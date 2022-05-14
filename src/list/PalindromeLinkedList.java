package list;

/**
 * @ClassName PalindromeLinkedList
 * @Description TODO
 * @Author katefu
 * @Date 5/14/22 10:24 AM
 * @Version 1.0
 **/
public class PalindromeLinkedList {
}

class Solution234{
    ListNode left;

    /*
    similar to post-order traversal in trees
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    /*
    optimize Space O

     */

    public boolean isPalindromeSample(ListNode head){
        //find mid-point of the linked list
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //if fast is not null
        //len(list) is odd, mid should move forward
        if (fast != null)
            slow = slow.next;

        //start from slow, reverse rest
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
