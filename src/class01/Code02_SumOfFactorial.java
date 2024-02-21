/**
 * @file Code02_SumOfFactorial.java
 * @author Eric
 * @version V0.01
 * @date 19-February-2024
 * @brief 计算阶乘之和
 ******************************************************************************
 * @attention
 *
 * THE PRESENT FUNCTIONS WHICH IS FOR GUIDANCE ONLY
 ******************************************************************************
 */

package class01;

public class Code02_SumOfFactorial {

    /**
     * 计算N!的值
     * @param N 要计算到的N
     * @return ans N!的值
     */
    public static long factorial(int N) {
        long ans = 1;

        for (int i = 1; i <= N; i++) {
            ans *= i;
        }

        return ans;
    }

    /**
     * 每次都计算到N的阶乘并累加
     * @param N 要计算到的N
     * @return ans 1!+2! +...+N!的值
     */
    public static long f1(int N) {
        long ans = 0;

        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }

        return ans;
    }

    /**
     * 每次只计算前一个数乘当前值并累加
     * @param N 要计算到的N
     * @return ans 1!+2! +...+N!的值
     */
    public static long f2(int N) {
        long ans = 0;
        long cur = 1;

        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }

        return ans;
    }

    /**
     * 测试f1和f2函数
     */
    public static void main(String[] args) {
        int N = 10;

        System.out.println(f1(N));
        System.out.println(f2(N));
    }
}