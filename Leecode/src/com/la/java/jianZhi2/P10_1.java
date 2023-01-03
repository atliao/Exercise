package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-24-19:49
 */
public class P10_1 {

    //1.递归：有重复的计算，时间开销很大
    public static int fib1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int x = fib1(n-1);
        int y = fib1(n-2);
        int s = x + y;
        return s;
    }

    //2.动态规划
    //只用三个变量，a，b，sum交替前进即可
    public static int fib(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for(int i = 1; i <= n; i++){ //f(0)可以直接返回，从f(1)开始循环
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(fib(i));
        }

    }
}
