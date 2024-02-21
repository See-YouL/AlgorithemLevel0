/**
 * @file Code01_PrintBinary.java
 * @author Eric
 * @version V0.01
 * @date 19-February-2024
 * @brief 打印整数的二进制
 ******************************************************************************
 * @attention
 *
 * THE PRESENT FUNCTIONS WHICH IS FOR GUIDANCE ONLY
 ******************************************************************************
 */

package class01;

public class Code01_PrintBinary {

    /**
     * 打印一个数的底层二进制数共36位
     * @param num 要打印的数
     */
    public static void print(int num) {
        /*
         * 对32位每个数进行对位与1相与来取出对应的01位
         */
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     *  测试函数
     */
    public static void main(String[] args) {
        int num = 4;
        print(num);
    }
}