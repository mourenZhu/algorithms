package cn.zhumouren.algorithms.sort;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 优先队列
 * @date 2021/11/14 17:06
 **/
public interface PriorityQueue<Key extends Comparable<Key>> {
    /**
     * 插入值
     *
     * @param key
     */
    void insert(Key key);

    /**
     * 返回优先值
     *
     * @return
     */
    Key getPriorVal();

    /**
     * 删除优先值
     *
     * @return
     */
    Key delPriorVal();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回队列大小
     *
     * @return
     */
    int size();

    /**
     * 控制台打印
     */
    void show();

}
