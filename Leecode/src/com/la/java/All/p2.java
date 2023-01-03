package com.la.java.All;

/**
 * @author LA
 * @date 2022-07-22-14:28
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {

        this.val = val;

    }
    ListNode(int val, ListNode next) {

        this.val = val; this.next = next;

    }
}

public class p2 {

    //-----------------------------------------将数字转化为链表----------------------------------------
    public static ListNode NumToListNode(int num){

        if(num < 0){
            System.out.println("输入不能小于0");
            return null;
        }

        if(num == 0){
            return new ListNode(0,null);
        }

        ListNode listNode = process(num,null);

        return listNode;
    }

    public static ListNode process(int num,ListNode node){

        if(num == 0){ //最终节点
            return null;
        }

        node = new ListNode(num%10);
        node.next = process(num/10,node.next);

        return node;
    }

    //-----------------------------------------逆序打印链表----------------------------------------
    public static void showListNode1(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    //-----------------------------------------顺序打印链表----------------------------------------
    public static void showListNode2(ListNode listNode){
        if(listNode == null){
            return;
        }
        showListNode2(listNode.next);
        System.out.print(listNode.val);
    }

    //-----------------------------------------解题-----------------------------------------
    public static ListNode solution1(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null){
            return null;
        }

        ListNode sum = new ListNode(0,null);
        ListNode node = addProcess(l1,l2,sum);
        return node;

    }

    public static ListNode solution2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode node = addProcess(l1,l2,0);
        return node;
    }

    public static ListNode addProcess(ListNode l1,ListNode l2,ListNode sum){

        if(l1 == null && l2 == null){ //加完了

            if(sum.val == 0){ //无进位
                return null;
            }else if (sum.val == 1){  //有进位
                return sum;
            }

        }

        if(l1 == null && l2 != null){
            sum = new ListNode(sum.val + l2.val,null);
            l2 = l2.next;
        }else if(l2 == null && l1 != null){
            sum = new ListNode(sum.val + l1.val,null);
            l1 = l1.next;
        }else{
            sum = new ListNode(sum.val + l1.val + l2.val,null);
            l1 = l1.next;
            l2 = l2.next;
        }

        if(sum.val >= 10){
            sum.val = sum.val%10;
            sum.next = new ListNode(1,null); //有进位
        }else{
            sum.next = new ListNode(0,null); //无进位
        }

        sum.next = addProcess(l1, l2, sum.next);

        return sum;
    }

    public static ListNode addProcess(ListNode l1,ListNode l2,int flag){
        if(l1 == null && l2 == null){
            return flag == 0 ? null : new ListNode(1,null);
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int sum = a + b + flag;
        flag = sum >= 10 ? 1 : 0;
        sum = sum%10;
        ListNode sumNode = new ListNode(sum,null);
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        sumNode.next = addProcess(l1, l2, flag);
        return sumNode;
    }

    public static void main(String[] args) {
        for(int i = 0;i < 10000; i++){
            int x = (int)(Math.random()*10000);
            int y = (int)(Math.random()*10000);
            //int x = 9999999;
            //int y = 9999;
            System.out.println(x + y);
            ListNode nodeX = NumToListNode(x);
            ListNode nodeY = NumToListNode(y);

            //nodeX = null;
            //nodeY = null;
            ListNode sum = solution2(nodeX,nodeY);
            showListNode1(sum);
            System.out.println();
        }

    }
}
