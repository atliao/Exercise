package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-25-13:54
 */
public class P11 {

    //自己写的，二分法
    int min;
    public int minArray(int[] numbers) {
        min = numbers[0];
        process(numbers, 0, numbers.length - 1);
        return min;
    }

    public void process(int[] numbers, int left, int right){
        if(right < left) {
           return;
        }
        int mid = left + (right - left)/2;
        if(mid > 0){
            if(numbers[mid - 1] > numbers[mid]){
                min =  numbers[mid];
                return;
            }
        }
        if(mid < numbers.length - 1)
        if(numbers[mid] > numbers[mid + 1]){
            min =  numbers[mid + 1];
            return;
        }
        process(numbers, left, mid - 1);
        process(numbers, mid + 1, right);

    }

    //题解：不用每次两边都搜索
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) { //如果numbers在mid的值小于最右边的值，说明旋转接点在左侧，查找左侧范围
                right = mid;
            } else if (numbers[mid] > numbers[right]) { //如果numbers在mid的值大于最右边的值，说明旋转点在右侧，查找右侧范围
                left = mid + 1;
            } else {
                right -= 1; //如果相等，right - 1，缩小搜索范围
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] array = {4,5,6,1};
        //int[] array = {1};
        int min = new P11().minArray(array);
        System.out.println(min);
    }
}
