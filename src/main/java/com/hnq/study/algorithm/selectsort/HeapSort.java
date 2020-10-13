package com.hnq.study.algorithm.selectsort;

import com.hnq.study.util.ArrayUtils;

import java.util.Arrays;

/**
 * 堆排序
 *
 * 堆得概念：
 * 堆：本质是一种数组对象，是一个近似完全二叉树的结构。特别重要的一点性质：
 * 任意的子节点小于（或大于）它的父节点（堆积的性质）。对此，又分为大顶堆和小顶堆；
 * 大顶堆：所有节点小于等于父节点，小顶堆：所有节点大于等于父节点，
 * 两者对左右孩子的大小关系不做任何要求。
 * 利用堆排序，就是基于大顶堆和小顶堆的一种排序方法。
 *
 * 大顶堆排序基本思想：
 * 1.首先将序列构建为大顶堆；（位于根节点的元素一定是当前序列的最大值）
 * （构建最大堆）
 * 2.取出当前大顶堆的根节点，将其余序列末尾元素进行交换；
 * 3.对剩余的n-1个元素进行调整，使其满足大顶堆的性质；
 * （维护最大堆）
 * 4.重复（2）（3）步骤，直至堆中只有一个元素为止
 *
 * @author henengqiang
 * @date 2020/1/15
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.genIntArr(20, 30, true);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 这里的索引是从0开始的，所以最后一个非叶子节点是arr.length / 2 - 1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 上述建堆结束，下面开始排序
        for (int i = arr.length - 1; i > 0; i--) {
            // 元素交换，作用是去掉大顶堆
            // 把大顶堆的根元素，放到数组的最后；
            // 换句话说，就是每一次堆调整之后，都会有一个元素到达自己的最终位置
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 元素交换之后，最后一个元素无需再考虑排序问题了
            // 接下来我们需要排序的，就是已经去掉部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 这里，实质上是自上而下，自左向右进行调整的
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        // 先把当前元素取出来，因为当前元素可能要一直移动
        int temp = arr[i];
        // 2 * i + 1为左子树i的左子树，2 * k + 1是k的左子树
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            // 先让k指向子节点中最大的节点
            // 如果有右子树，并且右子树大于左子树
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            // 如果发现节点（左右子节点）大于根节点，则进行值得交换
            if (arr[k] > temp) {
                int tmp = arr[k];
                arr[k] = arr[i];
                arr[i] = tmp;
                // 如果子节点更换了，那么，以子节点为根的子树会受到影响，所以，循环对子节点所在的数进行判断
                i = k;
            } else {
                // 不用交换，直接终止循环
                break;
            }
        }
    }
}
