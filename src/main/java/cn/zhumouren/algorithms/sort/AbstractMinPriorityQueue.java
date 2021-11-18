package cn.zhumouren.algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 最小值优先队列
 * @date 2021/11/14 17:24
 **/
public abstract class AbstractMinPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue {

    public AbstractMinPriorityQueue() {
    }

    /**
     * 创建一个初始容量为max的队列
     *
     * @param max
     */
    public AbstractMinPriorityQueue(int max) {
    }

    /**
     * 用a中元素创建一个优先队列
     *
     * @param a
     */
    public AbstractMinPriorityQueue(Key[] a) {
    }

}
