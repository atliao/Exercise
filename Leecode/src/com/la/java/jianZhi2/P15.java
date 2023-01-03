package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-26-20:16
 */
public class P15 {

    //有错，负数
    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int count = 0;
        while(n >= 2){
            if(n%2 == 1){
                count++;
            }
            n /= 2;
        }
        if(n == 1){
            count++;
        }
        return count;
    }

    public int solution(int n){
        int count = 0;
        while( n != 0){
            if((n & 1) == 1){  //将n、1进行与运算，最右边为1，则结果为1；运算后右移一位
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public int solution2(int n){
        int count = 0;
        while( n != 0){
            count++;
            n = n&(n-1); //n、n-1进行与运算后，会导致最右边的1变为0，当所有1变为0时，就停止
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P15().solution2(11));
    }
}
