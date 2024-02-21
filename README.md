# 左程云算法与数据结构新手班笔记

## 说明

- 课程为左程云算法与数据结构新手班
- 使用IDE为IDEA
- Java版本为19.0.2

## 第一课

### 打印二进制数

Code06_PrintB

将int整数的底层32位二进制打印

将num每一位(共32位)都和1相与, 相与结果为0则打印0, 为1则打印1

```java
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
```

### 反码和补码

int整型在java底层中以32位二进制数存储

bit31为符号位, bit30-bit0为数据位, 故最大值为2^31, 范围为-2^31~(2^31-1)

若为无符号数, 则最大值为2^32, 范围为0~2^32

符号位为0, 则表示非负数, 符号位为1, 则表示为负数

 负数的值为负数的数据位的值取反再加1

例如, *-1为11111111111111111111111111111111, 其中符号位bit31为1, 数据位bit30-bit0全为1, 将数据位取反则全为0, 加一后为000...1, 表示1*



### 左移与右移运算符

右移运算符>>,  右移以后, 用符号位补

右移运算符>>>,  右移以后, 用0补

左移运算符<<. 左移以后, 最低位用0补

### 相反数的位运算

对某数进行取反加一可以获得该数的相反数

```java
int a = 3;
int b = (~3+1); // b为-3
```

由于负数的最大绝对值为2^31, 而整数的最大绝对值为2^31-1

所以对于最小的负数取反加一后仍为自身值

最小负数为10000..000, 取反后为0111..1111, 加一后为10000...000, 仍为自身值

所以, 最小的负数没有对应的相反数

### 计算阶乘

![题目一](https://raw.githubusercontent.com/See-YouL/MarkdownPhotos/main/202402192159415.png)

```java
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
```

### 选择排序

![选择排序](https://raw.githubusercontent.com/See-YouL/MarkdownPhotos/main/202402192254337.png)

```java
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
```

### 冒泡排序

![冒泡排序](https://raw.githubusercontent.com/See-YouL/MarkdownPhotos/main/202402211550967.png)

冒泡排序操作思想

1. 0 1位置进行比较, 若arr[0] > arr[1] 则交换顺序
2. 1 2位置进行比较, 若arr[1] > arr[2] 则交换顺序
3. 2 3位置进行比较, 若arr[2] > arr[3] 则交换顺序
4. 以此类推
5. N-1 N位置进行比较, 若arr[N-1] > arr[N] 则交换顺序
6. 经过一轮全部排序后, 最大值在数列末尾即最大值为arr[N]
7. 重复1-5操作
8. 直到N-2 N-1位置进行比较交换, arr[N-1]为0~N-1中的最大值
9. 重复以上操作, 每次都能确定一个最大值在当前排序的末尾直到所有数完成排序

```java
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
```

### 插入排序

![插入排序](https://raw.githubusercontent.com/See-YouL/MarkdownPhotos/main/202402212048181.png)

1. 0-0 排序
2. 0-1 排序, 0 1比较交换
3. 0-2 排序, 2 1比较交换, 2 0比较交换
4. 0-3 排序, 3 2比较交换, 3 1比较交换, 3 0比较交换
5. 0-N-1 排序, N-1 N-2比较交换, N-1 N-3比较交换, N-1 N-4比较交换, ... , N-1 0比较交换(若不满足交换条件可跳出)

```java
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
```
