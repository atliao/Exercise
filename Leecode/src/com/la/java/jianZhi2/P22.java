package com.la.java.jianZhi2;

import com.la.java.structure.ListNode;


/**
 * @author LA
 * @createDate 2022-11-27-15:53
 */
public class P22 {


    //自己写的，递归
    ListNode resNode;
    int k;
    int p = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        this.k = k;
        process(head);
        return resNode;
    }

    public void process(ListNode node){
        if(node == null){
            return;
        }
        process(node.next);
        p++;
        if(p == k){
            resNode = node;
        }
    }

    //题解：双指针：快慢指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head; //用于指向第K+1个节点
        ListNode slow = head; //用于指向第1个节点

        while (fast != null && k > 0) { //将fast指针指向第K+1个节点
            fast = fast.next;
            k--;
        }
        while (fast != null) {//两者同时后移，由于相差K个节点，当fast指向空时，slow刚好指向倒数第K个节点
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.numToListNode(12345);
        System.out.println(new P22().getKthFromEnd(listNode, 2).val);
    }
}
