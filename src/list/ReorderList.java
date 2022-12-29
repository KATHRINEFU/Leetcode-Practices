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
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reorderList(n1);
        LinkedListNode cur = n1;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    static LinkedListNode reorderList(LinkedListNode head) {
// WRITE YOUR CODE HERE
        if(head==null) return null;
        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while(slow!=null && fast.next!=null){
            fast = fast.next.next;;
            slow = slow.next;
        }

        LinkedListNode rightHead = reverseList(slow.next);
        LinkedListNode leftHead = head;

        mergeList(leftHead, rightHead);

        return head;
    }

    static LinkedListNode reverseList(LinkedListNode head){
        if(head==null) return null;
        LinkedListNode pre = null;
        LinkedListNode cur = head;
        while(cur!=null){
            LinkedListNode aft = cur.next;
            cur.next = pre;
            pre = cur;
            cur = aft;
        }
        return pre;
    }

    static void mergeList(LinkedListNode left, LinkedListNode right){
        //left length >= right length
        if(left==null && right==null) return;
        while(right!=null){
            LinkedListNode next = left.next;
            left.next = right;
            left = right;
            right = next;
        }
    }
}

class LinkedListNode{
    int val;
    LinkedListNode next;

    public LinkedListNode(int node_value) {
        val = node_value;
        next = null;
    }
};