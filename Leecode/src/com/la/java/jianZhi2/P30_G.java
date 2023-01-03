package com.la.java.jianZhi2;

import java.util.LinkedList;

/**
 * @author LA
 * @createDate 2022-12-06-20:52
 */
public class P30_G {

    class MinStack {

        LinkedList<Integer> stack;
        LinkedList<Integer> stackP;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            stackP = new LinkedList<>();
        }

        public void push(int x) {
            stack.addLast(x);
            //stackP只存后续中最小的元素
            if(stackP.isEmpty()){
                stackP.addLast(x);
            }else if(stackP.getLast() >= x){
                stackP.addLast(x);
            }
        }

        public void pop() {
            if(stack.getLast().equals(stackP.getLast())){
                stackP.removeLast();
            }
            stack.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int min() {
            return stackP.getLast();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new P30_G().new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
