package com.la.java.jianZhi2;

import com.la.java.structure.ListNode;

/**
 * @author LA
 * @createDate 2022-12-05-14:50
 */
public class P25 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode head = null;
        ListNode cur = null;
        if(l1 != null && l2 == null){
            head = l1;
            l1 = l1.next;
        }else if(l1 == null && l2 != null){
            head = l2;
            l2 = l2.next;
        }else{
            if(l1.val > l2.val){
                head = l2;
                l2 = l2.next;
            }
            else{
                head = l1;
                l1 = l1.next;
            }
        }
        cur = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
               cur.next = l2;
               l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        while(l1 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head;
    }

    //题解：制造伪头节点
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode printN1 = head1;
        ListNode printN2 = head2;
        while(printN1 != null){
            System.out.print(printN1.val + " ");
            printN1 = printN1.next;
        }
        System.out.println();
        while(printN2 != null){
            System.out.print(printN2.val + " ");
            printN2 = printN2.next;
        }
        System.out.println();
        ListNode head = new P25().mergeTwoLists(head1, head2);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
