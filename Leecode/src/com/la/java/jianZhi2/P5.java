package com.la.java.jianZhi2;

/**
 * @author LA
 * @date 2022-10-06-12:59
 */
public class P5 {

    //方法一:java内置函数
    public String replaceSpace(String s){
        String newStr = s.replaceAll(" ","%20");
        return newStr;
    }

    //方法二：遍历
    public String replaceSpace2(String s){
        char[] strChar = s.toCharArray();
        StringBuilder newStr = new StringBuilder();
        for(char c : strChar){
            if( c == ' '){
                newStr.append("%20");
            }else{
                newStr.append(c);
            }
        }
        return newStr.toString();
    }
    public static void main(String[] args) {
        String str = "We are happy";
        String newStr = new P5().replaceSpace2(str);
        System.out.println(newStr);
    }
}
