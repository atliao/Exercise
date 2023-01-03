/**
 * @author LA
 * @date 2022-07-09-20:41
 *
 * 已知一个int[] arr数组中
 * 1.有一个数出现了奇数次，其他数都出现了偶数次，求出这个奇数次的数
 * 2.若有两个数出现了奇数次，其他数出现了偶数次，求这两个数
 * 要求复杂度为 O(n),即不能用双循环来记录每一个数出现的次数
 *
 * 1.解：用异或，出现偶数次的数，异或为0，出现奇数次的数，异或后为 0^a，最后得到a
 * 2.解：假设两个数为a和b，将所有数异或，得到的结果为 t = a ^ b,由于a!=b,则a和b一定存在一个二进制位不相同，分别为1和0;
 * 将所有在该位置上，只为1（或0）的数异或，偶数次的全部抵消为0，奇数次的只能为a和b中的一个（因为在该位上两数不同），异或后
 * 得到结果t'，t' = a^b^(所有a异或的结果) 或 t' = a^b^(所有b异或的结果),可得到a或b，将t' 与t异或，得到另一个
 */


public class p1 {
    public static void solution1(int[] arr){
        int tmp = 0;
        for(int i : arr){
            tmp = tmp ^ i;
        }
        System.out.println(tmp);

    }

    public static void solution2(int[] arr){
        int eor = 0;
        for(int i : arr){
            eor = eor ^ i; //结果为a ^ b
        }
        int RightOne = eor & (~eor + 1); //取出一个数二进制最右侧为1的位置,此处可得到异或结果eor的最右侧1，即a和b不相同的位置

        int eor2 = 0;
        for(int i : arr){
            if((i & RightOne) == 0){ //取该位置上为1的数
                eor2 = eor2 ^ i; //异或,最终结果为a或b
            }
        }
        int a = eor2;
        int b = eor2 ^ eor;
        System.out.println(a + " " + b);

    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,2,7,1,3,5,2,7,1,1,3};
        solution1(arr1);

        int[] arr2 = {1,3,5,2,7,1,3,5,2,7,3,2};
        solution2(arr2);

    }
}
