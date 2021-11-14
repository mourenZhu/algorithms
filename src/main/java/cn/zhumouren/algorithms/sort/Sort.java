package cn.zhumouren.algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2021/11/8 20:12
 **/
public abstract class Sort {
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void sort(Comparable[] a) {
        sort(a, SortType.QUICK_TO_INSERTION);
    }

    public static void sort(Comparable[] a, SortType type) {
        switch (type) {
            case SELECTION:
                Selection.sort(a);
                break;
            case INSERTION:
                Insertion.sort(a);
                break;
            case SHELL:
                Shell.sort(a);
                break;
            case MERGE_TOP_DOWN:
                MergeTopDown.sort(a);
                break;
            case MERGE_BOTTOM_UP:
                MergeBottomUp.sort(a);
                break;
            case QUICK_DEFAULT:
                Quick.sort(a);
                break;
            case QUICK_TO_INSERTION:
                Quick.sort(a, type);
                break;
            default:
                break;
        }
    }

}
