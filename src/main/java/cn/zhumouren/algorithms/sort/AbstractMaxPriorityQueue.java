package cn.zhumouren.algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 最大值优先队列
 * @date 2021/11/14 17:12
 **/
public abstract class AbstractMaxPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue {
    protected Key[] data;

    public AbstractMaxPriorityQueue() {
    }

    /**
     * 创建一个初始容量为max的队列
     *
     * @param max
     */
    public AbstractMaxPriorityQueue(int max) {
    }

    /**
     * 用a中元素创建一个优先队列
     *
     * @param a
     */
    public AbstractMaxPriorityQueue(Key[] a) {
    }

}
