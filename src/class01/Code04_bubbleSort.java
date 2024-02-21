/**
 * @file Code04_bubbleSort.java
 * @author Eric
 * @version V0.01
 * @date 21-February-2024
 * @brief 冒泡排序(不使用对数器)
 ******************************************************************************
 * @attention
 *
 * THE PRESENT FUNCTIONS WHICH IS FOR GUIDANCE ONLY
 ******************************************************************************
 */

package class01;

import java.util.Currency;

public class Code04_bubbleSort {

    /**
     * 打印数组中的元素
     * @param arr 需要打印的数组
     */
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    /**
     * 将数组中两位置的数交换
     * @param arr 要进行交换的数组
     * @param i 交换位置1
     * @param j 交换位置2
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];

        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 冒泡排序
     * @param arr 进行选择排序的数组
     */
    public static void bubbleSort(int[] arr) {
        int N = arr.length;

        // 边界条件, 数组为空或数组长度小于2
        if (null == arr || arr.length < 2) {
            return;
        }

        // 0 - N-1
        // 0 - N-2
        // 0 - N-3
        for(int end = N - 1; end >= 0; end--) {
            // 0 ~ end
            // 对比排序01, 12, 23, second-1 second, ..., end-1 end
            for (int second = 1; second <= end; second++) {
                if (arr[second] > arr[second - 1]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {

        int[] arr = {7, 1, 3, 8, 9, 0};

        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}