/**
 * @file Code03_SelectionSort.java
 * @author Eric
 * @version V0.01
 * @date 21-February-2024
 * @brief 选择排序(不使用对数器)
 ******************************************************************************
 * @attention
 *
 * THE PRESENT FUNCTIONS WHICH IS FOR GUIDANCE ONLY
 ******************************************************************************
 */

package class01;

public class Code03_SelectionSort {

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
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        int N = arr.length;

        // 边界条件, 数组为空或数组长度小于2
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 0; i < N; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < N; j++) {
                // arr[j]如果比原最小值还小则j为新的最小值坐标, 不满足则不变
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }

            swap(arr, i, minValueIndex);
        }

    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {

        int[] arr = {7, 1, 3, 8, 9, 0};

        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}