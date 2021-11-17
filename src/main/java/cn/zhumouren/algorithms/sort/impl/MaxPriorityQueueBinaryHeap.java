package cn.zhumouren.algorithms.sort.impl;

import cn.zhumouren.algorithms.sort.AbstractMaxPriorityQueue;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 基于二叉堆的优先队列
 * @date 2021/11/17 10:45
 **/
public class MaxPriorityQueueBinaryHeap<Key extends Comparable<Key>> extends AbstractMaxPriorityQueue {

    /**
     * 堆的长度
     */
    private int N = 0;

    public MaxPriorityQueueBinaryHeap(int max) {
        data = new Comparable[max + 1];
    }

    @Override
    public void insert(Comparable v) {
        data[++N] = v;
        swim(N);
    }

    @Override
    public Key getPriorVal() {
        return (Key) data[1];
    }

    @Override
    public Key delPriorVal() {
        Key max = (Key) data[1];
        exch(1, N--);
        // 防止对象游离
        data[N + 1] = null;
        // 恢复有序
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void show() {
        for (int i = 1; i < N; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = (Key) data[i];
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
        while (2 * k <= N) {
            int j = 2 * k;
            // 判断该层哪个子节点比较大
            if (j < N && less(j, j + 1)) {
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
