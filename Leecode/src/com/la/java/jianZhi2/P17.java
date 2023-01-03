package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-27-13:00
 */
public class P17 {
    //不考虑大数
    public int[] printNumbers1(int n) {
       int max = (int)Math.pow(10, n) - 1;
        int[] array = new int[max];
        for(int i = 0; i < max; i++){
            array[i] = i + 1;
        }
        return array;
    }

    //考虑大数
    //无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型

    //1.不考虑去除0，并且不要求位数
    StringBuilder res;
    int n;
    char[] num;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs1(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs1(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs1(x + 1); // 开启固定第 x + 1 位
        }
    }

    //考虑去除0，并且严格要求位数
    StringBuilder res2;
    int nine = 0;
    int start;
    int base = 10;
    int n2;
    char[] num2;
    char[] loop2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers3(int n) {
        this.n2 = n;
        res2 = new StringBuilder();
        num2 = new char[n];
        for(int i = 0; i < n; i++){
            num2[i] = 0;//初始化
        }
        start = n - 1;//截取的下标位置
        dfs(0);
        res2.deleteCharAt(res2.length() - 1);
        return res2.toString();
    }
    void dfs(int x) {
        if(x == n2) {
            if(nine >= base){ //截取之前，先判断截取位数
                start--;//截取的下标位置
                base *= 10;
            }
            String s = String.valueOf(num2);
            s = s.substring(start);
            if(!s.equals("0")) res2.append(s + ","); //不需要0，从1开始的

            return;
        }
        for(char i : loop2) {
            num2[x] = i;
            dfs(x + 1);
            nine++;
        }
        nine--;//防止高位+1时，导致nine增加
    }

    public static void main(String[] args) {
        int[] array1 = new P17().printNumbers1(2);
        for(int x : array1){
            System.out.print(x + " ");
        }
        System.out.println();
        String array2 = new P17().printNumbers2(3);
        System.out.println(array2);
        String array3 = new P17().printNumbers3(3);
        System.out.println(array3);


    }
}
