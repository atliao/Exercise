package com.la.java.jianZhi2;

import java.util.Arrays;

/**
 * @author LA
 * @createDate 2022-11-29-18:46
 */
public class P21 {
    //荷兰国旗问题，只从左边开始扩增奇数部分
    public static int[] exchange1(int[] nums) {
        int left = 0; //左边界
        int i = 0;
        while(i < nums.length){
            if(nums[i]%2 == 1){
                swap(nums, i, left);
                left++;
            }
            i++;
        }
        return nums;

    }

    //左右两边分别扩充奇数和偶数部分，就不用遍历完整个数组，而是在中间相遇
    public static int[] exchange2(int[] nums) {
        int left = 0; //左边界
        int right = nums.length - 1; //右边界
        int index = 0;
        while(index < right){ //没有越界
            if(nums[index]%2 == 1){
                swap(nums, index, left);
                left++;
                index++;
            }
            else{ //与右边交换时，新交换过来的数还没有看过，因此index不++
                swap(nums, index, right);
                right--;
            }
        }
        return nums;

    }

    //只有考虑右边界就行了，奇数本来在前面，只需要保持不动
    public static int[] exchange3(int[] nums) {
        int right = nums.length - 1; //右边界
        int index = 0;
        while(index < right){ //没有越界
            if(nums[index]%2 == 0){
                swap(nums, index, right);
                right--;
            }
            else{
                index++;
            }
        }
        return nums;
    }

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //写在一起，同时用异或运算
    public static int[] exchange(int[] nums) {
        int right = nums.length - 1; //右边界
        int index = 0;
        while(index < right){ //没有越界
            if(nums[index]%2 == 0){ //偶数做交换
                nums[index] = nums[index]^nums[right];
                nums[right] = nums[index]^nums[right];
                nums[index] = nums[index]^nums[right];
                right--;
            }
            else{
                index++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {6,2,4,1,3,5};
        System.out.println(Arrays.toString(exchange1(array)));
        System.out.println(Arrays.toString(exchange2(array)));
        System.out.println(Arrays.toString(exchange3(array)));
        System.out.println(Arrays.toString(exchange(array)));
    }
}
