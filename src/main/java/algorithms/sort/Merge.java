package algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2021/11/12 20:12
 **/
public abstract class Merge extends Sort {

    protected static Comparable[] aux;

    /**
     * 将a[lo...mid]和a[mid+1...hi]归并
     *
     * @param a   数组
     * @param lo  最小值
     * @param mid 中间值
     * @param hi  最大值
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
}
