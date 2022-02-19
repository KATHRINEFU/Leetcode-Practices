package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-12 9:23
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1();
        ListNode1 n2 = new ListNode1();
        ListNode1 n3 = new ListNode1();
        ListNode1 n4 = new ListNode1();
        ListNode1 n5 = new ListNode1();
        n1.val=1;
        n2.val=2;
        n3.val=3;
        n4.val=4;
        n5.val=5;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Solution19 test = new Solution19();
        test.removeNthFromEndSample(n1,2);
    }
}

class Solution19 {
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        if(head.next==null) return null;
        ListNode1 temp = head;
        int i=1;
        int length=1;
        while(temp.next!=null){
            temp = temp.next;
            length++;
        }

        temp = head;
        if(n==1){
            while(true){
                if(i==length-n){
                    temp.next = null;
                    return head;
                }
                temp = temp.next;
                i++;
            }
        }else if(n==length){
            head = head.next;
            return head;
        }
        else{
            int target = length-n;
            while(true){
                if(i==target){
                    temp.next = temp.next.next;
                    return head;
                }
                temp = temp.next;
                i++;
            }
        }
    }

    public ListNode1 removeNthFromEndSample(ListNode1 head, int n) {
        ListNode1 newHead = new ListNode1(0);
        newHead.next = head;
        ListNode1 p = newHead;
        ListNode1 runner = newHead;
        while(n>0){
            runner = runner.next;
            n--;
        }
        while(runner.next!=null){
            runner = runner.next;
            p=p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}