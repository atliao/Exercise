package com.la.java.structure;

/**
 * @author LA
 * @date 2022-11-22-13:20
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}

    public ListNode(int val) {
        this.val = val;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next;
        node.next = new ListNode(3);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
