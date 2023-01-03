package com.la.java.jianZhi2;

import java.util.HashMap;

/**
 * @author LA
 * @createDate 2022-12-11-20:56
 */
public class P39 {

    //利用hash表
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = nums[0];
        int maxCount = 1;
        for(int i = 0; i < nums.length; i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 1);
            }else{
                Integer count = hashMap.get(nums[i]);
                count++;
                hashMap.put(nums[i], count);
                if(count > maxCount){
                    maxCount = count;
                    res = nums[i];
                }
            }
        }
        return res;
    }

    //题解：摩尔投票法
    public int majorityElement2(int[] nums) {
        int vote = 0;
        int x = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == x){
                vote++;
            }else{
                vote--;
            }
            if(vote == 0){
                x = nums[i + 1];
            }
        }
        return x;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = new P39().majorityElement2(a);
        System.out.println(res);
    }
}
