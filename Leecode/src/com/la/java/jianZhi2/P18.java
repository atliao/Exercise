package com.la.java.jianZhi2;


/**
 * @author LA
 * @date 2022-11-21-16:09
 */

public class P18 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

    }

    public static ListNode numToListNode(int num){
        ListNode head = null;
        ListNode nextNode;

        if(num == 0){
            head = new ListNode();
            head.val = 0;
            return head;
        }

        while(num != 0){
            nextNode = head;
            head = new ListNode();
            head.val = num % 10;
            head.next = nextNode;
            num /= 10;
        }
        return head;
    }


    //自己写的方法
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val){
            return head.next;
        }
        process(head,val);
        return head;
    }

    public void process(ListNode head, int val){
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    //题解方法：题解思想加上自己的改进
    public ListNode deleteNode1(ListNode head, int val){
        if(head.val == val){
            return head.next;
        }
        ListNode curNode = head;
        while(curNode.next != null){
            if(curNode.next.val == val){
                curNode.next = curNode.next.next;
                break;
            }
            curNode = curNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int x = 123456789;
        //int x = 0;
        ListNode node = numToListNode(x);
        ListNode printNode = node;
        while(printNode != null){
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }
        System.out.println();
        ListNode head = new P18().deleteNode1(node, 0);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
