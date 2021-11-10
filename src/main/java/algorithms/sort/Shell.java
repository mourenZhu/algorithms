package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

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
            for (int i = h; i < l; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        System.out.println(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
