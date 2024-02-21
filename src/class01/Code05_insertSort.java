/**
 * @file Code05_insertSort.java
 * @author Eric
 * @version V0.01
 * @date 21-February-2024
 * @brief 插入排序(不使用对数器)
 ******************************************************************************
 * @attention
 *
 * THE PRESENT FUNCTIONS WHICH IS FOR GUIDANCE ONLY
 ******************************************************************************
 */

package class01;

public class Code05_insertSort{

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
     * 插入排序
     * @param arr 进行选择排序的数组
     */
    public static void insertSort(int[] arr) {
        int N = arr.length;

        // 边界条件, 数组为空或数组长度小于2
        if (null == arr || arr.length < 2) {
            return;
        }

        /*
         * 0 ~ 0 排序, 无需排序
         * 0 ~ 1 排序
         * 0 ~ 2 排序
         * 0 ~ N-1 排序
         */
        for (int end = 1; end <= N - 1; end++){
            /*
             * (1 0) 交换
             * (2 1) 交换 (1 0) 交换
             * (3 2) 交换 (2 1) 交换 (1 0) 交换
             * (pre pre-1) 交换 (pre-1 pre-2) 交换 ... (1 0)交换
             */

            for (int pre = end; (pre > 0) && (arr[pre - 1] > arr[pre]) ; pre--) {
                swap(arr, pre, pre - 1);
            }

        }

    }

    /**
     * 测试函数
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {7, 1, 3, 8, 9, 0};

        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }
}
