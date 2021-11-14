package cn.zhumouren.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 归并排序-自顶向下
 * @date 2021/11/11 15:24
 **/
public class MergeTopDown extends Merge {

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 左半边排序
        sort(a, lo, mid);
        // 右半边排序
        sort(a, mid + 1, hi);
        // 归并
        merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
