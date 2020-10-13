package com.hnq.study.algorithm.insertsort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 希尔排序
 * 又称“缩小增量排序”，是直接插入排序算法一种更高效的改进版本。
 * 希尔排序是非稳定排序算法。
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序
 * 算法排序；随着增量逐渐减小，每组包含的关键词就越来越多，当
 * 增量减至1时，增个记录恰好被分成一组，算法便终止。
 *
 * 希尔排序的算法思路：
 * 将待排序数组按照步长gap进行分组，然后将每组的元素利用
 * 直接插入排序方式进行排序；每次将gap折半减小，循环上诉操作；
 * 当gap=1时，利用直接插入完成排序。
 *
 * @author henengqiang
 * @date 2020/1/14
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(20, 30, true);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int gap = arr.length;
        while (true) {
            // 增量每次减半
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
            if (gap == 1) {
                break;
            }
        }
    }

}
