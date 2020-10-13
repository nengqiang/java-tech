package com.hnq.study.algorithm.exchangesort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 快速排序
 * 是对冒泡排序的一种改进
 *
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另一部分的所有数据要小，然后再按
 * 此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行。
 *
 * 快速排序的基本思想：挖坑填数+分治法
 * 1.从序列当中选择一个基准数（pivot）
 * 2.将序列中的所有数依次遍历，比基准数
 * 大的放在其右侧，比基准数小的放在其左侧
 * 3.对左侧和右侧的数据重复步骤1.2.，直到所有子集当中只有一个元素为止
 *
 * @author henengqiang
 * @date 2020/1/16
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(10, 20, false);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[i] < pivot) {
                i++;
            }
            while (i < j && arr[j] > pivot) {
                j--;
            }
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            qSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            qSort(arr, j + 1, end);
        }
    }

}
