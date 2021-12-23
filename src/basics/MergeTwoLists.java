package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-22 18:03
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next=n3;
        n4.next=n5;
        n5.next=n6;

        Solution4 test = new Solution4();
        ListNode res = test.mergeTwoLists(n1,n4);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution4 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode start;
        if(list1.val<=list2.val) {
            start=list1;
            list1 = list1.next;
        }
        else {
            start=list2;
            list2 = list2.next;
        }

        ListNode temp=start;
        while(true){
            if(list1==null){
                temp.next = list2;
                break;
            }
            if(list2==null){
                temp.next = list1;
                break;
            }

            if(list1.val<=list2.val){
                temp.next=list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next=list2;
                list2 = list2.next;
                temp=temp.next;
            }
        }
        return start;
    }

    public ListNode mergeTwoListsSample(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}