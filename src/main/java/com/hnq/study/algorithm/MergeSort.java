package com.hnq.study.algorithm;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 归并排序
 * 是稳定排序算法
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法，
 * 该算法是采用分治法的一个典型的应用。它的基本操作是：
 * 将已有的子序列合并，达到完全有序的序列；即先使子序列有序，
 * 再使子序列段间有序。
 * 归并排序其实要做两件事情：
 *  分解——将序列每次折半拆分
 *  合并——将划分后的序列段两两排序合并
 * 若将两个有序表合并成一个有序表，称为二路归并。
 *
 * @author henengqiang
 * @date 2020/1/31
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(10, 20, false);
        System.out.println(Arrays.toString(arr));
        int[] sortArr = mergeSort(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    private static int[] mergeSort(int[] arr) {
        return mSort(arr, 0, arr.length - 1);
    }

    private static int[] mSort(int[] arr, int l, int h) {
        if (l == h) {
            return new int[] {arr[l]};
        }

        int mid = l + (h - l) / 2;
        // 左有序数组
        int[] leftArr = mSort(arr, l, mid);
        // 右有序数组
        int[] rightArr = mSort(arr, mid + 1, h);
        // 新有序数组
        int[] newArr = new int[leftArr.length + rightArr.length];

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newArr[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newArr[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newArr[m++] = rightArr[j++];
        }
        return newArr;
    }

}
