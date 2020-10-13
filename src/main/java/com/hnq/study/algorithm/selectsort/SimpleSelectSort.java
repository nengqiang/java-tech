package com.hnq.study.algorithm.selectsort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 简单选择排序
 * 是不稳定排序
 *
 * 简单选择排序的基本思路：比较+交换
 * 1.从待排序的序列中，找到关键字最小的元素
 * 2.如果最小元素不是待排序序列的第一个元素，
 * 将其和第一个元素互换
 * 3.从余下n-1个元素中，重复(1)(2)(3)，直到
 * 排序结束
 *
 * @author henengqiang
 * @date 2020/1/15
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(20, 30, true);
        simpleSelectSort(arr);
        System.out.println(Arrays.toString(arr));

        Comparable[] data = {1, 1, 10, 7, Integer.MIN_VALUE, 2};
        simpleSelectSort2(data);
        System.out.println(Arrays.toString(data));
    }

    private static void simpleSelectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int pos = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private static void simpleSelectSort2(Comparable[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int pos = i;
            for (int j = i + 1; j < len; j++) {
                if (data[j].compareTo(data[pos]) < 0) {
                    pos = j;
                }
            }
            Comparable temp = data[i];
            data[i] = data[pos];
            data[pos] = temp;
        }
    }

}
