package com.hnq.study.algorithm.insertsort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 直接插入排序
 * 是一种最简单的排序方法，其基本操作是将一条记录
 * 插入到已排好的有序表中，从而得到一个新的、记录数
 * 增1的有序表。
 *
 * 直接插入排序的核心思想就是：
 * 将数组中的所有元素依次跟前面已经排好的元素相比较，
 * 如果选择的元素比已排序的元素小，则交换，直到全部
 * 元素都比较过。
 *
 * @author henengqiang
 * @date 2020/1/14
 */
public class StraightInsertSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(20, 30, true);
        straightInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void straightInsertSort(int[] arr) {
        // 第0位独自作为有序数列，从第1位开始向后遍历
        for (int i = 1; i < arr.length; i++) {
            // 0~i-1位为有序，若第i位小于i-1位，继续寻位并插入；否则认为0~i位也是有序的，忽略此次循环
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j = i - 1;
                // 从第i-1位向前遍历并移位，直至找到小于第i位值停止
                while (j >= 0 && temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                // 插入第i位的值
                arr[j + 1] = temp;
            }
        }
    }

}
