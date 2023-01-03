package com.la.java.jianZhi2;

import java.util.LinkedList;

/**
 * @author LA
 * @createDate 2022-12-07-20:40
 */
public class P31_G {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 || popped.length == 0){
            return true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.addLast(pushed[i]);
            while(!stack.isEmpty()) {
                if(stack.getLast().equals(popped[j])){
                    stack.removeLast();
                    j++;
                }else{
                    break;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        while(!stack.isEmpty()){
            if(stack.getLast().equals(popped[j])){
                stack.removeLast();
                j++;
            }
            else{
                break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }


    //题解：后面的都不需要，最前面的判断也不需要
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for(int num : pushed) {
            stack.addLast(num); // num 入栈
            while(!stack.isEmpty() && stack.getLast().equals(popped[i])) { // 循环判断与出栈
                stack.removeLast();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {2,1,0};
        int[] b = {1,2,0};
        boolean result = new P31_G().validateStackSequences(a, b);
        System.out.println(result);
    }
}
