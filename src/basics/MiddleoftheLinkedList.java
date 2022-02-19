package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-12 8:26
 */
public class MiddleoftheLinkedList {
}


class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
 }

class Solution876 {
    public ListNode1 middleNode(ListNode1 head) {
        int length=1;
        ListNode1 temp = head;
        while(temp.next!=null){
            temp = temp.next;
            length++;
        }

        int target = length/2+1;
        int i=1;
        temp =head;
        while(true){
            if(i==target) return temp;
            temp = temp.next;
            i++;
        }
    }

    public ListNode1 findMiddle(ListNode1 head){
        ListNode1 fast = head;
        ListNode1 slow = fast;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}