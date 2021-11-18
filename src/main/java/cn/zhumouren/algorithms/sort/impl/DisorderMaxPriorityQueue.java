package cn.zhumouren.algorithms.sort.impl;

import cn.zhumouren.algorithms.sort.AbstractMaxPriorityQueue;
import cn.zhumouren.algorithms.sort.Sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 最大值优先队列-无序
 * @date 2021/11/15 9:02
 **/
public class DisorderMaxPriorityQueue<Key extends Comparable<Key>> extends AbstractMaxPriorityQueue {
    /**
     * 最大值索引
     */
    private int maxPoint = -1;
    /**
     * 队列长度的索引
     */
    private int lengthPoint = 0;

    public DisorderMaxPriorityQueue() {
        data = new Comparable[0];
    }

    public DisorderMaxPriorityQueue(int max) {
        data = new Comparable[max];
        System.out.println(this);
    }

    public DisorderMaxPriorityQueue(Comparable[] a) {
        data = new Comparable[a.length];
        System.arraycopy(a, 0, data, 0, a.length);
        lengthPoint = a.length - 1;
    }

    @Override
    public void insert(Comparable comparable) {
        if (lengthPoint < data.length - 1) {
            data[lengthPoint++] = comparable;
        }
    }

    @Override
    public Key getPriorVal() {
        if (maxPoint != -1) {
            return (Key) data[maxPoint];
        }
        maxPoint = getMaxPoint();
        return (Key) data[maxPoint];
    }

    @Override
    public Key delPriorVal() {
        if (lengthPoint == 0) {
            return null;
        }
        if (maxPoint == -1) {
            maxPoint = getMaxPoint();
        }
        Comparable max = data[maxPoint];
        Sort.exch(data, maxPoint, lengthPoint);
        lengthPoint--;
        maxPoint = -1;
        return (Key) max;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }


    @Override
    public int size() {
        return lengthPoint;
    }

    @Override
    public void show() {
        for (int i = 0; i <= lengthPoint; i++) {
            System.out.printf(data[i] + " ");
        }
        System.out.println();
    }

    private int getMaxPoint() {
        int mp = 0;
        for (int i = 1; i <= lengthPoint; i++) {
            if (Sort.less(data[mp], data[i])) {
                mp = i;
            }
        }
        return mp;
    }

}
