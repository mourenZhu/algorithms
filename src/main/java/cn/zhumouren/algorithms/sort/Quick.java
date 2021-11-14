package cn.zhumouren.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 快速排序
 * @date 2021/11/13 16:54
 **/
public class Quick extends Sort {

    /**
     * 当数组长度小于等于这个值时，改用插入排序可以提高排序速度
     */
    private static final int M = 8;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, SortType.QUICK_DEFAULT);
    }

    public static void sort(Comparable[] a, SortType type) {
        switch (type) {
            case QUICK_DEFAULT:
                sort(a, 0, a.length - 1);
                break;
            case QUICK_TO_INSERTION:
                sortToInsertion(a, 0, a.length - 1);
                break;
            default:
                break;
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 改进版快速排序，当数组较小时，切换到插入排序。
     *
     * @param a
     * @param lo
     * @param hi
     */
    private static void sortToInsertion(Comparable[] a, int lo, int hi) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sortToInsertion(a, lo, j - 1);
        sortToInsertion(a, j + 1, hi);
    }

    /**
     * 划分并获取中间值
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 从左边开始扫描
            while (less(a[++i], v)) {
                // 一直累加，如果达到最高值打破循环
                if (i == hi) {
                    break;
                }
            }
            // 从右边开始扫描
            while (less(v, a[--j])) {
                // 一直累减，如果达到最低打破循环
                if (j == lo) {
                    break;
                }
            }
            // 判断数组是否已全部遍历
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        // 把v放入正确的位置
        exch(a, lo, j);
        // a[lo...j-1] <= a[j] <= a[j+1...hi]达成
        return j;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
