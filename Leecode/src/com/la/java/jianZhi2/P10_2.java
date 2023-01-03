package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-24-20:29
 */
public class P10_2 {

    //1阶有1种跳法，2阶有2种跳法，3阶有1+2种跳法，所以为满足性质，假设0阶有1种跳法
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        int a = 1; //1阶
        int b = 2; //2阶
        int sum;
        for(int i = 2; i <= n; i++){ //0阶和1阶可以直接返回，从2阶开始循环
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }



    //如果要存储所有的台阶数的值，需要开辟O(N)的空间
    public int numWaysPlus(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }
        return dp[n];
    }
}
