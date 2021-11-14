package cn.zhumouren.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 希尔排序
 * @date 2021/11/8 21:00
 **/
public class Shell extends Sort {
    public static void sort(Comparable[] a) {
        int l = a.length;
        int h = 1;
        // 分配h，1, 4, 13, 40, 121, 364, 1093...
        while (h < l / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 开启相距h的列表，每一次新的循环就是给一个新的值来开启插入排序，其中每h次循环后就是开启一个新的列表
            for (int i = h; i < l; i++) {
                // 这里就是插入排序的精髓，插入时排序，保证下次插入时前面的数都是有序的
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
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
