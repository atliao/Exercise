package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2023-01-02-18:05
 */
public class P33_G {
    //方法一：递归分治
    public boolean verifyPostorder(int[] postorder) {
        return process(postorder, 0, postorder.length - 1);
    }
    public boolean process(int[] postorder, int i, int j){ //某个子树为二叉搜索树的正确性
        if(i >= j){
            return true;
        }
        int p = i;
        while(true){
            if(postorder[p] < postorder[j]){ //右子树都大于根
                p++;
            }
            else{
                break;
            }
        }

        int m = p; //右子树部分的第一个下标

        //左子树部分已经保证全部小于根节点值
        //true

        //右子树部分是否全部大于根节点值
        while(postorder[p] > postorder[j]){
            p++;
        }
        if(p != j){
            return false;
        }

        //递归分治
        boolean a = process(postorder, i, m - 1);
        boolean b = process(postorder, m, j - 1);
        return a&&b;
    }

    public static void main(String[] args) {
        int[] postorder = {1,3,2,6,8,7,5};
        boolean b = new P33_G().verifyPostorder(postorder);
        System.out.println(b);
    }
}
