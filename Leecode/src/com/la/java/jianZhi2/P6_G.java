package com.la.java.jianZhi2;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author LA
 * @date 2022-10-06-13:34
 */


public class P6_G {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
    }

    public static ListNode numToListNode(int num){
        ListNode node = new ListNode();
        return createList(num, node);
    }

    public static ListNode createList(int num, ListNode node){

        if(num < 10){
            node.val = num;
            return node;
        }

        ListNode preNode = new ListNode();

        node.val = num % 10;

        preNode.next = node;

        num = num / 10;

        ListNode Head = createList(num, preNode);

        return Head;
    }


    //逆序打印：该方法不开辟额外的空间
    int[] array;
    int n = 0;
    int i = 0;

    public int[] reversePrint(ListNode head){

        ListNodePrint(head);
        return array;
    }

    public void ListNodePrint(ListNode node){
        if(node == null){
            array = new int[n];//再没有下一个节点后，再初始化数组
            return;
        }
        n++;//每个节点使n++，最后能得到所有节点的个数
        ListNodePrint(node.next);
        array[i++] = node.val;
    }


    //题解方法都开辟了额外的空间
    //题解方法一：递归
    ArrayList<Integer> tmp = new ArrayList<>();
    public int[] reversePrint1(ListNode head){
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i= 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;
    }

    public void recur(ListNode node){
        if(node == null){
            return;
        }
        recur(node.next);
        tmp.add(node.val);
    }

    //题解方法二： 利用栈，后进后出
    public int[] reversePrint2(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 123456789;
        ListNode node = numToListNode(x);
        int[] array = new P6_G().reversePrint2(node);
        for(int n : array){
            System.out.print(n);
        }
    }
}




