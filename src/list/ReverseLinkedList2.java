package list;

/**
 * @ClassName ReverseLinkedList2
 * @Description
 *     Given the head of a singly linked list and two integers left and right where left <= right,
 *     reverse the nodes of the list from position left to position right, and return the reversed list.
 * @Author katefu
 * @Date 5/13/22 11:03 PM
 * @Version 1.0
 **/
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        int left=2;
        int right=4;
        Solution92 test  = new Solution92();
        ListNode res = test.reverseBetween(n1,left,right);
        System.out.println(res.val);
    }
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==0){
            return reverseFirstN(head, right);
        }

        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    public ListNode reverseFirstN(ListNode head, int n){
        ListNode successor = null;
        if(n==1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseFirstN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
