package com.la.java.jianZhi2;

import java.util.Arrays;

/**
 * @author LA
 * @createDate 2022-12-06-20:23
 */
public class P29_G {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int size = matrix.length * matrix[0].length;
        int[] a = new int[size];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int i;
        int n = 0;
        while(true) {
            for (i = left; i <= right; i++) {
                a[n] = matrix[top][i];
                n++;
                if (n == size) {
                    return a;
                }
            }
            top++;
            for (i = top; i <= bottom; i++) {
                a[n] = matrix[i][right];
                n++;
                if (n == size) {
                    return a;
                }
            }
            right--;
            for (i = right; i >= left; i--) {
                a[n] = matrix[bottom][i];
                n++;
                if (n == size) {
                    return a;
                }
            }
            bottom--;
            for (i = bottom; i >= top; i--) {
                a[n] = matrix[i][left];
                n++;
                if (n == size) {
                    return a;
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] A= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(A.length);
        System.out.println(A[0].length);
        int[] a = new P29_G().spiralOrder(A);
        System.out.println(Arrays.toString(a));
    }
}
