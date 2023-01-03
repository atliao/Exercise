package com.la.java.jianZhi2;

/**
 * @author LA
 * @date 2022-09-29-17:28
 * 类似二叉树查询
 */
public class P4_G {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= (matrix.length - 1) && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }

            if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {};
        boolean b = new P4_G().findNumberIn2DArray(arr,3);
        System.out.println(b);
    }
}
