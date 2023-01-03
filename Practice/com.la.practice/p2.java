import org.junit.Test;

import java.util.Date;

/**
 * @author LA
 * @date 2022-07-11-19:48
 *
 * 在有序数组中，找到大于等于一个数的最左边的位置
 * 如：arr = 12222333335666678889999中，找到大于等于3的最左边的位置，为 arr[5]
 * 要求时间复杂度 O(logN)
 * 二分法思路
 *
 */
public class p2 {

    //二分法

    public static int solution(int[] arr, int a){
        if(arr == null || arr[arr.length -1] < a){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (true){

            int t = (start + end) / 2;

            if(arr[t] >= a){
                if(t - 1 < 0){
                    return t;
                }
                if(arr[t - 1] < a){
                    return t;
                }
                end = t - 1;
            }
            else{
                start = t + 1;
            }

        }
    }

    //简单遍历 O(N)
    public static int solution2(int[] arr,int x){
        if(arr == null || arr[arr.length -1] < x){
            return -1;
        }

        if(arr[0] >= x){
            return 0;
        }

        int i = 1;
        while(true){

            if(arr[i] >= x && arr[i - 1] < x ){
                return i;
            }

            i++;
        }
    }

    @Test
    public void test(){
        int[] arr = {1,1,2,2,2,2,3,3,3,3,3,5,6,6,6,6,7,8,8,8,9,9,9,9};
        int x = 2;
        int p = solution(arr,x);
        if( p < 0){
            System.out.println("not found!");
        }else{
            System.out.println("arr["+ p + "]=" + arr[p]);
        }
    }

    @Test
    public void test2(){
        int[] arr = {1,2,2,2,4,7,8,8,8,8,9};
        int x = -1;
        int p = solution(arr,x);
        if( p < 0){
            System.out.println("not found!");
        }else{
            System.out.println("arr["+ p + "]=" + arr[p]);
        }
    }


    public int test3(){
        int[] arr = new int[5000];
        int i = 0;
        int num = 0;
        while(true){
            int x = (int)(Math.random()*2);
            if(x == 1){
                num = num + 1;
            }
            arr[i] = num;
            i++;
            if(i == 50){
                break;
            }
        }

        for(int a : arr){
            System.out.print(a + " ");
        }


        int x = (int)( Math.random() * (arr[4999] + 2) );
        System.out.println("\nfind : " + x);

        long t1 = System.nanoTime();

        System.out.print("solution 1 :");
        int p = solution(arr,x);
        if( p < 0){
            System.out.println("not found!");
        }else{
            System.out.println("arr["+ p + "]=" + arr[p]);
        }

        long t2 = System.nanoTime();

        long time1 = t2 - t1;
        System.out.println("solution1 : " + time1 + "ns");

        t1 = System.nanoTime();

        System.out.print("solution 2 :");
        p = solution2(arr,x);
        if( p < 0){
            System.out.println("not found!");
        }else{
            System.out.println("arr["+ p + "]=" + arr[p]);
        }

        t2 = System.nanoTime();

        long time2 = t2 - t1;
        System.out.println("solution2 : " + time2 + "ns");

        if(time2 > time1){
            return 1;
        }else{
            return 0;
        }

    }

    @Test
    public void test4(){
        int count = 0;
        for(int i = 0; i < 500; i++){
            int r = test3();
            if(r == 1){
                count++;
            }
        }
        System.out.println("solution 1 < solution 2 : " + count + "times");

    }
    @Test
    public void test5(){

        long t1 = System.nanoTime();
        System.out.println(System.nanoTime() - t1);

    }
}
