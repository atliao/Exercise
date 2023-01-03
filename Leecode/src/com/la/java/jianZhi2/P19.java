package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-28-19:42
 */
public class P19 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) { //i从0开始，表示空字符，i=1才表示第一个字符，但对应的是s中下标为0的字符
            for (int j = 1; j <= n; ++j) { //第j个位置的字符
                if (p.charAt(j - 1) == '*') { //对应p字符串中下标为j-1的字符
                    f[i][j] = f[i][j - 2]; //先假定不对应，不匹配该*和前面的字符组合，丢掉p中的这两个字符，匹配结果等同于丢掉2个的p
                    if (matches(s, p, i, j - 1)) { //查看*前面的字符和s中的i位置匹配不匹配
                        f[i][j] = f[i][j] || f[i - 1][j]; //匹配就等同于前i-1和p中的前j匹配的结果，或者扔掉了也匹配
                    }
                } else {
                    if (matches(s, p, i, j)) { //没有*就看两个位置单独的字符是否匹配
                        f[i][j] = f[i - 1][j - 1];//匹配就与前i-1和j-1相同的匹配结果
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        boolean[] b = new boolean[5];
        for(boolean bb : b){
            System.out.println(bb);
        }
    }
}
