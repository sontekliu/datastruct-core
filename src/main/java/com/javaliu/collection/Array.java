package com.javaliu.collection;

/**
 * 描 述：数组
 * 类 名：Array
 * 作 者：javaliu
 * 创 建：2019年09月18日 10:56:00
 * 版 本：V1.0.0
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 构造数组对象
     * @param capacity      初始化时的容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认的构造方法，初始化容量为 10
     */
    public Array() {
        this(10);
    }

    /**
     * 数组的大小
     * @return  数组的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组所能容纳的数据的多少
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     * @return      true:空, false:非空
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
