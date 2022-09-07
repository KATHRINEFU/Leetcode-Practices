package OA;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description
 *
 * 给定两个非空的链表，表示两个非负的整数。它们每位数字都是按逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：list1 = [2,4,3], list2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * 用链表实现
 * @Author katefu
 * @Date 9/1/22 10:38 PM
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;

        ListNode n7 = test(n1, n2);
        ListNode temp = n7;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static List<Integer> test(List<Integer> l1, List<Integer> l2){
        int n = l1.size();
        int m = l2.size();
        int i=0;
        int add = 0;
        List<Integer> res = new ArrayList<>();
        while (i<n || i<m){
            int total = ((i<n)?l1.get(i):0)+((i<m)?l2.get(i):0);
            int cur = (total+add)%10;
            add = total/10;
            res.add(cur);
        }

        if(add!=0) res.add(add);
        return res;
    }

    public static ListNode test(ListNode n1, ListNode n2){
        if(n1==null && n2==null) return null;
        ListNode cur1 = n1;
        ListNode cur2 = n2;
        ListNode res = new ListNode(0);
        ListNode cur3 = res;
        int add = 0;
        while(cur1!= null || cur2!= null){
            int total = ((cur1!=null)?cur1.val:0)+((cur2!=null)? cur2.val : 0);
            int cur = (total+add)%10;
            add = (total+add)/10;
            cur3.val = cur;
            cur3 = cur3.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if(add!=0){
            cur3.next = new ListNode(add);
        }

        return res;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
