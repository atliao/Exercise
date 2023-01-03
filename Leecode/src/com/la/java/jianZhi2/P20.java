package com.la.java.jianZhi2;

import javax.sound.midi.Soundbank;

/**
 * @author LA
 * @createDate 2022-12-01-16:21
 */
public class P20 {

    public static boolean isNumber(String s) {

        if(s.equals("")){
            return false;
        }
        int flagCount = 0;
        int pointCount = 0;
        int firstPoint = -1;
        int secondPoint = -1;
        int eCount = 0;
        int numCount = 0;
        int sCount = 0;
        int emptyCount = 0;
        int eFlag = 0;
        int[] nums=new int[2];
        int p=0;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){

            //数字
            if((str[i]>='0'&&str[i]<='9')){
                numCount++;
            }
            //不是表示数值的字符
            if( !(   (str[i]>='0'&&str[i]<='9')||str[i]=='.'||str[i]==' '||str[i]=='-'||str[i]=='+'||str[i]=='e'||str[i]=='E'   ) ){
                return false;
            }
            //判断空格情况
            if(str[i] == ' '){
                //空格不能出现在字符串中间
                if(i==0) {
                    eFlag = 0;
                }
                if(i-1>=0){
                    if(str[i-1]!=' '){
                        eFlag = 1;
                    }
                }
                if(i+1<str.length){
                    if(str[i+1]!=' '&&eFlag == 1){
                        return false;
                    }
                }

                continue;
            }

            //判断+和-的情况
            if(str[i] == '+' || str[i] == '-'){
                //符号计数
                flagCount++;

                //符号不能在末尾
                if(i == str.length - 1){
                    System.out.println("符号不通过");
                    return false;
                }

                //符号前面只能是空、空格或e或E
                if( str[i] == '+' ){
                    if(i!=0){
                        if( !(str[i-1]==' '||str[i-1]=='e'||str[i-1]=='E') ){
                            System.out.println("符号不通过");
                            return false;
                        }
                    }
                }
                if( str[i] == '-' ){
                    if(i!=0){
                        if( !(str[i-1]==' '||str[i-1]=='e'||str[i-1]=='E'||str[i-1]=='+') ){
                            System.out.println("符号不通过");
                            return false;
                        }
                    }
                }

                //是否为一个正确的符号
                if(str[i+1] == str[i]){
                    System.out.println("符号不通过");
                    return false;
                }
                if(str[i] == '-' && str[i+1] == '+'){
                    System.out.println("符号不通过");
                    return false;
                }
                if(str[i] == '+' && str[i+1] == '-'){
                    flagCount--;
                    continue; //+-只代表一个flagCount
                }


                //符号后面只能是数字或.
                if(  !(  (str[i+1]<='9'&&str[i+1]>='0')  ||  str[i+1]=='.'  )  ){
                    System.out.println("符号不通过");
                    return false;
                }

                //超过两个符号
                if(flagCount > 2){
                    System.out.println("符号不通过");
                    return false;
                }

            }

            //判断.情况
            if(str[i] == '.'){
                pointCount++;
                //点超过两个
                if(pointCount > 2){
                    System.out.println(".不通过");
                    return false;
                }
                nums[p] = numCount;
                p++;


                //点前面只能是空、空格和符号和数字
                if(i!=0){
                    if(!( str[i-1]==' ' || str[i-1]=='-' || str[i-1]=='+' || (str[i-1]>='0'&&str[i-1]<='9'))){
                        System.out.println(".e不通过");
                        return false;
                    }
                }

                //点后面只能是空或数字或空格或e
                if(i!=str.length-1){
                    if( !(  (str[i+1]>='0'&&str[i+1]<='9')||str[i+1]==' '||str[i+1]=='e' ||str[i+1]=='E' ) ){
                        System.out.println(".不通过");
                        return false;
                    }
                }

                //两个点中间不能全是数字
                if(pointCount==1){
                    firstPoint=i;
                }
                if(pointCount==2){
                    secondPoint=i;
                    if(secondPoint - firstPoint - 1 == nums[1] - nums[0]){
                        System.out.println(".不通过");
                        return false;
                    }
                }


            }

            //判断e或E
            if(str[i] == 'e' || str[i] == 'E'){

                eCount++;

                //e不能在开始和结尾
                if(i==0||i==str.length-1){
                    System.out.println("e或E不通过");
                    return false;
                }

                //e前只能是数字或.
                if(!((str[i-1]>='0'&&str[i-1]<='9')||str[i-1]=='.')){
                    System.out.println("e或E不通过");
                    return false;
                }
                //e后只能是整数
                if(!(  (str[i+1]>='0'&&str[i+1]<='9')||str[i+1]=='+'||str[i+1]=='-')){
                    System.out.println("e或E不通过");
                    return false;
                }
                if(i+2<str.length){
                    if(str[i+2]=='.'){
                        System.out.println("e或E不通过");
                        return false;
                    }
                }
                if(i+3<str.length){
                    if(str[i+3]=='.'){
                        System.out.println("e或E不通过");
                        return false;
                    }
                }

                //e超过1个
                if(eCount > 1){
                    System.out.println("e或E不通过");
                    return false;
                }

                //.e1和1e.不能前后无数字连续
                if(i+1<=str.length-1){
                    if(i-1>=0){
                        if(i-2<0){
                            if(str[i-1]=='.'&&(str[i+1]>='0'&&str[i+1]<='9')){
                                System.out.println(".不通过");
                                return false;
                            }
                        }
                        if(i-2>=0){
                            if(str[i-1]=='.'&&(str[i+1]>='0'&&str[i+1]<='9')&&(!(str[i-2]>='0'&&str[i-2]<='9'))){
                                System.out.println(".不通过");
                                return false;
                            }
                        }
                        if(i+2>str.length-1){
                            if(str[i+1]=='.'&&(str[i-1]>='0'&&str[i-1]<='9')){
                                System.out.println(".不通过");
                                return false;
                            }
                        }
                        if(i+2<=str.length-1){
                            if(str[i+1]=='.'&&(str[i-1]>='0'&&str[i-1]<='9')&&(!(str[i+2]>='0'&&str[i+2]<='9'))){
                                System.out.println(".不通过");
                                return false;
                            }
                        }

                    }
                }

            }

        }
        //没有数字
        if(numCount == 0){
            return false;
        }
        return true;
    }

    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            //去掉首位空格
            s = s.trim();
            boolean numFlag = false;
            boolean dotFlag = false;
            boolean eFlag = false;
            for (int i = 0; i < s.length(); i++) {
                //判定为数字，则标记numFlag
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numFlag = true;
                    //判定为.  需要没出现过.并且没出现过e
                } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                    dotFlag = true;
                    //判定为e，需要没出现过e，并且出过数字了
                } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                    eFlag = true;
                    numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                    //判定为+-符号，只能出现在第一位或者紧接e后面
                } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                    //其他情况，都是非法的
                } else {
                    return false;
                }
            }
            return numFlag;
        }
    }

    //网友答案
    public boolean isNumber2(String s) {
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
    public static void main(String[] args) {
        System.out.println(isNumber("47e-5.5" ));
    }
}
