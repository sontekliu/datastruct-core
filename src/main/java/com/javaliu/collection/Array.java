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

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
