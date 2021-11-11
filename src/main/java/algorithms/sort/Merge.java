package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 归并排序
 * @date 2021/11/11 15:24
 **/
public class Merge extends Sort {

    private static Comparable[] aux;

    /**
     * 将a[lo...mid]和a[mid+1...hi]归并
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 复制元素
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        /*
           进行了四次判断。
           左半边用尽，取右半边。
           右半边用尽，取左半边。
           右半边较小，取右半边。
           左半边较小，去左半边。
         */
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length - 1];
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
        System.out.println(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
