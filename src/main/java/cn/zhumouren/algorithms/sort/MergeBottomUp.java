package cn.zhumouren.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 归并排序-自底向上
 * @date 2021/11/12 20:17
 **/
public class MergeBottomUp extends Merge {

    public static void sort(Comparable[] a) {
        int l = a.length;
        aux = new Comparable[l];
        // 从最小数组开始两两归并，1, 2, 4...
        for (int sz = 1; sz < l; sz = sz + sz) {
            // 按sz间距开始归并，0, 2, 4...
            for (int lo = 0; lo < l - sz; lo += sz + sz) {
                // 最后Math.min是预防索引越界
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, l - 1));
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
