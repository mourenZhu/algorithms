package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 插入排序
 * @date 2021/11/8 20:20
 **/
public class Insertion extends Sort {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
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
