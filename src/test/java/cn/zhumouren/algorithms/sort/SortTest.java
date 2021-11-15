package cn.zhumouren.algorithms.sort;

import cn.zhumouren.algorithms.utils.StdIn;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 排序测试
 * @date 2021/11/15 10:24
 **/
public class SortTest {

    @Test
    public void SelectionTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.SELECTION);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void InsertionTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.INSERTION);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ShellTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.SHELL);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void MergeBottomUpTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.MERGE_BOTTOM_UP);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void MergeTopDownTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.MERGE_TOP_DOWN);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void QuickTest() {
        try {
            String[] a;
            String path = ClassLoader.getSystemClassLoader().getResource("array-test.txt").getPath().substring(1);
            a = StdIn.readAllStringsByFile(path);
            System.out.println(Arrays.toString(a));
            Sort.sort(a, SortType.QUICK_TO_INSERTION);
            assert Sort.isSorted(a);
            Sort.show(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
