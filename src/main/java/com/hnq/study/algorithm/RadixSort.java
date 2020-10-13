package com.hnq.study.algorithm;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 基数排序
 * 是稳定性排序
 *
 * 基数排序属于“分配式”排序，又称“桶子法”或 bin sort
 * （最高位优先和最低位优先），顾名思义，
 * 它是通过键值的部分资讯，将要排序的元素分配至某些“桶”中，籍以
 * 达到排序的作用。在某些时候，基数排序的效率要高于其他稳定性排序法。
 *
 *
 * @author henengqiang
 * @date 2020/1/31
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(10, 20, false);
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        rSort(arr, String.valueOf(max).length());
    }

    /**
     * @param d     表示数组中最大的数有多少位，若最大的数是100，则有3位
     */
    private static void rSort(int[] arr, int d) {
        int k = 0;
        int n = 1;
        // 控制键值排序依据在哪一位
        int m = 1;

        // 数组的第一堆表示可能的余数为0-9
        int[][] temp = new int[10][arr.length];
        // order[i]表示该位是i的数的个数
        int[] order = new int[10];
        while(m <= d) {
            for (int value : arr) {
                int lsd = (value / n) % 10;
                temp[lsd][order[lsd]] = value;
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }

}
