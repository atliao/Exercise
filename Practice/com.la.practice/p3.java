/**
 * @author LA
 * @date 2022-07-12-10:20
 *
 * int[] arr 无序，任何两个相邻的数不相等，求局部最小：该位置的数比左右两边都小
 * 一定存在局部最小
 * 若在0位置，arr[0] < arr[1]
 * 若在N-1位置，arr[N-1] < arr[N-2]；
 * 若在其它位置 i , arr[i-1] < arr[i] < arr[i+1]；
 * 要求时间复杂度 O(logN)
 */
public class p3 {

    //二分法
    public static int solution(int[] arr){
        if(arr == null){
            return -1;
        }

        //若两端为局部最小，直接返回
        if(arr[0] < arr[1]){
            return 0;
        }

        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }

        //在中间，则二分
        int start = 0;
        int end = arr.length - 1;

        while (true){

            int t = (start + end) / 2;

            if(t == 0 ){ //在始端了
                return t + 1;
            }

            if(start == t){ //集中在一起了
                return t;
            }

            if(arr[t] < arr[t - 1] && arr[t] < arr[t + 1]){
                return t;
            }
            else{
                if(arr[t] > arr[t - 1]){
                    end = t - 1;
                }
                else if(arr[t] > arr[t + 1])
                {
                    start = t + 1;
                }

            }

        }

    }

    public static int solution2(int[] arr){
        if(arr == null){
            return -1;
        }

        //若两端为局部最小，直接返回
        if(arr[0] < arr[1]){
            return 0;
        }

        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }

        return 0;


    }
    public static void main(String[] args) {

        int[] arr = {6,5,4,0,3,8};
        int p = solution(arr);
        System.out.println("arr[" + p + "] = " + arr[p]);
    }
}
