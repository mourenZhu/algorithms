package cn.zhumouren.algorithms.sort.impl;

import cn.zhumouren.algorithms.sort.AbstractMaxPriorityQueue;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 基于二叉堆的优先队列
 * @date 2021/11/17 10:45
 **/
public class BinaryHeapMaxPriorityQueue<Key extends Comparable<Key>> extends AbstractMaxPriorityQueue {

    private Key[] data;

    /**
     * 使用的数据长度
     */
    private int length;

    public BinaryHeapMaxPriorityQueue(Comparable[] a) {
        data = (Key[]) new Comparable[a.length + 1];
        for (int i = 0; i < length; i++) {
            insert(a[i]);
        }
    }

    private BinaryHeapMaxPriorityQueue() {
        super();
    }

    public BinaryHeapMaxPriorityQueue(int max) {
        data = (Key[]) new Comparable[max + 1];
    }

    @Override
    public void insert(Comparable v) {
        data[++length] = (Key) v;
        swim(length);
    }

    @Override
    public Key getPriorVal() {
        return data[1];
    }

    @Override
    public Key delPriorVal() {
        Key max = data[1];
        exch(1, length--);
        // 防止对象游离
        data[length + 1] = null;
        // 恢复有序
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void show() {
        for (int i = 1; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 由下至上的堆有序化-上浮
     *
     * @param k
     */
    private void swim(int k) {
        // 不断与父节点比较
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 由上至下的堆有序化-下沉
     *
     * @param k 当前值索引
     */
    private void sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            // 判断该层哪个子节点比较大
            if (j < length && less(j, j + 1)) {
                j++;
            }
            // 判断是否比最大的子节点还大
            if (!less(k, j)) {
                break;
            }
            // 与最大的子节点交换
            exch(k, j);
            k = j;
        }
    }
}
