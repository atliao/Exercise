package com.la.java.jianZhi2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author LA
 * @createDate 2022-11-24-16:54
 */
public class P9 {


    //自己写的，由于stack是由Vector继承而来，里面用Object[]存储数据，因此时间开销较大
    class CQueue {

        private Stack<Integer> stack;
        //辅助用的栈，是stack中元素的倒序弹出
        private Stack<Integer> stackAssist;

        public CQueue() {
            stack = new Stack<>();
            stackAssist = new Stack<>();
        }

        public void appendTail(int value) {

            //正常进栈
            stack.push(value);

        }

        public int deleteHead() {
            Integer res;

            //1.如果两个栈都没有元素
            if(stackAssist.isEmpty()&&stack.isEmpty()){
                return -1;
            }

            //2.如果辅助栈里还有元素，直接弹出
            if(!stackAssist.isEmpty()){
                return stackAssist.pop();
            }

            //3.如果原栈中有元素，此时辅助栈无元素了，将原栈中的所有元素弹给辅助栈
            while(!stack.isEmpty()){
                Integer peek = stack.pop();
                stackAssist.push(peek);
            }
            //在将辅助栈最顶层元素弹出
            return stackAssist.pop();

        }
    }


    //题解方法：用链表存储的，操作时间更快
    class CQueue2 {


        LinkedList<Integer> stackA, stackB;
        public CQueue2() {
            stackA = new LinkedList<Integer>();
            stackB = new LinkedList<Integer>();
        }
        public void appendTail(int value) {
            stackA.addLast(value);
        }
        public int deleteHead() {
            if(!stackB.isEmpty()) return stackB.removeLast();
            if(stackA.isEmpty()) return -1;
            while(!stackA.isEmpty())
                stackB.addLast(stackA.removeLast());
            return stackB.removeLast();
        }

    }


    public static void main(String[] args) {
        CQueue2 cQueue = new P9().new CQueue2();
        cQueue.appendTail(3);
        int head;
        head = cQueue.deleteHead();
        System.out.println(head);
        head = cQueue.deleteHead();
        System.out.println(head);
        head = cQueue.deleteHead();
        System.out.println(head);
    }
}
