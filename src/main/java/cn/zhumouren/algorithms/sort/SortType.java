package cn.zhumouren.algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 排序类型
 * @date 2021/11/14 10:27
 **/
public enum SortType {
    // 选择排序
    SELECTION,
    // 插入排序
    INSERTION,
    // 希尔排序
    SHELL,
    // 归并排序-自底向上
    MERGE_BOTTOM_UP,
    // 归并排序-自顶向下
    MERGE_TOP_DOWN,
    // 快速排序的初始方法
    QUICK_DEFAULT,
    // 快速排序-数组较小时转插入排序
    QUICK_TO_INSERTION
}
