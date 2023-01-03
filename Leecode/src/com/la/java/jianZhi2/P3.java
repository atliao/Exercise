package com.la.java.jianZhi2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LA
 * @date 2022-09-29-10:22
 */
public class P3 {

    public int findRepeatNumber(int[] nums) {
        Set hashSet = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(hashSet.contains(nums[i])){
                return nums[i];
            }
            hashSet.add(nums[i]);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for(int i = 0; i < nums.length;){

            if(nums[i] == i){ //说明该数字在该位置，无需交换
                i++;
            }else{

                if(nums[nums[i]] == nums[i]){//说明nums[i]和i位置的数字是相同的，找到了重复
                    return nums[i];
                }

                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,0,3,2,3,6,5,4,7};
        int num1 = new P3().findRepeatNumber(arr);
        int num2 = new P3().findRepeatNumber2(arr);
        //System.out.println(num1);
        System.out.println(num2);
    }


}
