package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-25-20:18
 */
public class P14_2 {

    public int cuttingRope(int n) {
        if(n <= 3){
            return n-1;
        }
        if(n == 4){//其实不用单独列出来，如果是4，最后本来就会return res*n=4;
            return 4;
        }
        long res = 1;
        int mod = 1000000007;
        while(n > 4){ //等于4时，2*2最大，不用拆成1和3；5以上就可以拆出3来
            res *= 3;
            res = res % mod;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new P14_2().cuttingRope(10));
    }
}
