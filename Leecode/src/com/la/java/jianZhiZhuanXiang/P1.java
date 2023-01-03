package com.la.java.jianZhiZhuanXiang;

/**
 * @author LA
 * @date 2022-09-27-15:13
 */
public class P1 {

    //solution of myself
    public int divide(int a, int b) {

        // 考虑被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (a == 0) {
            return 0;
        }

        //一般情况
        boolean flag = (a > 0 && b < 0)||(a < 0 && b > 0)? false : true;

        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;

        int result = 0;//最终结果

        while(a - b >= 0){
            int d = b;//当前除数
            int c = 1;//当前商
            while((d + d < a) && (d + d >= 0) /*判断两个d相加是否会溢出*/ ){
                d = d + d;//除数倍增
                c = c + c;//商倍增
            }
            result = result + c;
            a = a - d;
        }

        return flag ? result : -result;
    }

    public static void main(String[] args) {
        int a = -1658356636;
        int b = -1639504005;
        int res = new P1().divide(a,b);
        System.out.println(res);
    }
}
