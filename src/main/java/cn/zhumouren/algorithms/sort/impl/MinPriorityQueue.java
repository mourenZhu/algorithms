package cn.zhumouren.algorithms.sort.impl;

import cn.zhumouren.algorithms.sort.PriorityQueue;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 最小值优先队列
 * @date 2021/11/14 17:24
 **/
public class MinPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue {

    public MinPriorityQueue() {
    }

    /**
     * 创建一个初始容量为max的队列
     *
     * @param max
     */
    public MinPriorityQueue(int max) {
    }

    /**
     * 用a中元素创建一个优先队列
     *
     * @param a
     */
    public MinPriorityQueue(Key[] a) {
    }

    @Override
    public void insert(Comparable comparable) {

    }

    @Override
    public Key getPriorVal() {
        return null;
    }

    @Override
    public Key delPriorVal() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
