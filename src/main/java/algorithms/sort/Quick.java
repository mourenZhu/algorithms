package algorithms.sort;

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
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
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
            //
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        //
        exch(a, lo, j);
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
