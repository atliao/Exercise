package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-25-19:08
 */
public class P14_1 {


    //数学推导方法
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int x = n % 3;
        if(x == 0){
            return (int)Math.pow(3,n/3);
        }
        else if(x == 1){
            return ( (int)Math.pow(3,(n-3)/3) ) * 4;
        }
        else{
            return ( (int)Math.pow(3,n/3) ) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P14_1().cuttingRope(10));
    }
}
