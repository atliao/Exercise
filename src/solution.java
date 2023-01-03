import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LA
 * @date 2022-08-04-10:11
 */
public class solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n];
        int i;
        for(i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        int len = 0;
        int high;
        int maxH = getMax(arr);
        for(high = maxH; high >=0 ; high--){
            for(i = 0; i < n; i++){
                if(arr[i] > high){
                    len++;
                }
            }
            if(len >= m){
                break;
            }
        }

        System.out.println(high);


    }

    public static int getMax (int [] array) {
        int max = array[0];  //局部变量写在方法内部
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max ) {
                max = array[i];
            }
        }
        return max;
    }



}
