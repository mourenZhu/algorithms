package cn.zhumouren.algorithms;

import cn.zhumouren.algorithms.sort.Sort;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description todo
 * @date 2021/11/8 15:58
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Algorithms!");
        sortTest();
    }

    public static void sortTest() {
        String[] a = StdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        Sort.sort(a);
        assert Sort.isSorted(a);
        Sort.show(a);
    }
}
