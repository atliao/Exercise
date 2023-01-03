package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-27-11:03
 */
public class P16_G {

    //快速幂：二进制角度
    public double myPow1(double x, int n) {
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        long b = n;
        if(n < 0){
            b = -b;
            x = 1/x;
        }
        while( b > 0){
            if( (b & 1) == 1 ){
                res *= x;
            }

            x *= x;

            b = b >> 1;
        }
        return res;
    }

    //快速幂：二分法角度，递归方式
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N); //n小于0，转换为n大于0的计算方式
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2); //每次分为x^N/2次方计算
        y = y * y;
        if(N % 2 == 1){ //当指数是基数时，需要多乘一个x
            y = y * x;
        }
        return y;
    }


    public static void main(String[] args) {
        System.out.println(new P16_G().myPow1(1, -2147483648));
        System.out.println(new P16_G().myPow2(2, 7));
    }
}
