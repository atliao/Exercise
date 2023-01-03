package com.la.java.All;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LA
 * @date 2022-07-22-13:07
 *
 * 给定一个整数数组 num和一个整数目标值 target
 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class p1 {

    //O(N^2)
    public static int[] getIndex(int[] arr, int target){

        int[] ans = new int[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    ans[index++] = i;
                    ans[index++] = j;
                }
            }
        }
        int[] answer = new int[index];
        for(int i = 0; i < index; i++){
            answer[i] = ans[i];
        }
        return answer;
    }

    //O(N) 哈希
    public static int[] getIndex2(int[] arr, int target){
        Map<Integer,Integer> hashTable = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(hashTable.containsKey(target - arr[i])){
                return new int[]{hashTable.get(target - arr[i]), i};
            }
            hashTable.put(arr[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,1,9,8,5};
        int[] index = getIndex2(arr,6);
        for(int i = 0; i < index.length; i++){
            System.out.print(index[i] + " ");
        }
    }
}
