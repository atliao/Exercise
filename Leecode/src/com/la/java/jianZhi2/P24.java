package com.la.java.jianZhi2;

import com.la.java.structure.ListNode;

import java.util.List;

/**
 * @author LA
 * @createDate 2022-12-03-20:37
 */
public class P24 {

    //递归：时间空间都为O(N)
    ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        process(head);
        return newHead;
    }

    public ListNode process(ListNode node){
        if(node.next == null){
            newHead = new ListNode(node.val);
            return newHead;
        }
        ListNode preNode = process(node.next);
        preNode.next = new ListNode(node.val);
        return preNode.next;
    }


    //题解：双指针，时间O(N)，空间O(1)
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null; //新的头存在pre里
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        for(int i = 3; i <=5; i++){
            node.next = new ListNode(i);
            node = node.next;
        }

        ListNode printNode = head;
        while(printNode != null){
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }

        System.out.println();

        ListNode reverseNode = new P24().reverseList(head);

        while(reverseNode != null){
            System.out.print(reverseNode.val + " ");
            reverseNode = reverseNode.next;
        }


    }
}
