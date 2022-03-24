package basics;

import java.util.HashMap;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode141 l1 = new ListNode141(3);
        ListNode141 l2 = new ListNode141(2);
        ListNode141 l3 = new ListNode141(0);
        ListNode141 l4 = new ListNode141(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        Solution141 test = new Solution141();
        test.hasCycle(l1);
    }
}

 class ListNode141 {
     int val;
     ListNode141 next;
     ListNode141(int x) {
         val = x;
         next = null;
      }
}

class Solution141 {
    public boolean hasCycle(ListNode141 head) {
        if(head.next==null) return false;

        ListNode141 temp = head;
        HashMap<ListNode141, Integer> map = new HashMap<>();
        int len=0;
        while(temp.next!=null){
            if(map.get(temp)!=null && map.get(temp)==1) return false;
            map.put(temp, 1);
            temp = temp.next;
            len++;
        }
        return true;

    }
    /*
    Use two pointers, walker and runner.
    walker moves step by step. runner moves two steps at time.
    if the Linked List has a cycle walker and runner will meet at some point.
     */
    public boolean hasCycleSample(ListNode141 head) {
        if(head==null) return false;
        ListNode141 walker = head;
        ListNode141 runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
