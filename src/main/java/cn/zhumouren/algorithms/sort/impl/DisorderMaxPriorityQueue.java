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

    private Key[] data;

    /**
     * 使用的数据长度
     */
    private int length;

    /**
     * 最大值索引
     */
    private int maxIndex = -1;

    private DisorderMaxPriorityQueue() {

    }

    public DisorderMaxPriorityQueue(int max) {
        data = (Key[]) new Comparable[max];
        System.out.println(this);
    }

    public DisorderMaxPriorityQueue(Comparable[] a) {
        data = (Key[]) new Comparable[a.length];
        System.arraycopy(a, 0, data, 0, a.length);
        length = a.length - 1;
    }

    @Override
    public void insert(Comparable comparable) {
        if (length < data.length - 1) {
            data[length++] = (Key) comparable;
        }
    }

    @Override
    public Key getPriorVal() {
        if (maxIndex != -1) {
            return data[maxIndex];
        }
        maxIndex = getMaxPoint();
        return data[maxIndex];
    }

    @Override
    public Key delPriorVal() {
        if (length == 0) {
            return null;
        }
        if (maxIndex == -1) {
            maxIndex = getMaxPoint();
        }
        Comparable max = data[maxIndex];
        Sort.exch(data, maxIndex, length);
        length--;
        maxIndex = -1;
        return (Key) max;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }


    @Override
    public int size() {
        return length;
    }

    @Override
    public void show() {
        for (int i = 0; i <= length; i++) {
            System.out.printf(data[i] + " ");
        }
        System.out.println();
    }

    private int getMaxPoint() {
        int mp = 0;
        for (int i = 1; i <= length; i++) {
            if (Sort.less(data[mp], data[i])) {
                mp = i;
            }
        }
        return mp;
    }

}
