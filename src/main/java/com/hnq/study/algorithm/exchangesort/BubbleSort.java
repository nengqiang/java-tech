package com.hnq.study.algorithm.exchangesort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 是稳定排序算法
 *
 * 冒泡排序思路比较简单：
 * 1.将序列中左右元素依次比较，保证右边的元素始终大于左边的元素；
 * （第一轮结束后，序列最后一个元素一定是当前序列的最大值）
 * 2.对序列中剩余n-1个元素再次执行步骤1
 *
 * @author henengqiang
 * @date 2020/1/16
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(20, 30, true);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 对序列中剩余n-1个元素再次执行步骤1
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
