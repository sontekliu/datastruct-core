package com.javaliu.collection.array;

/**
 * 描 述：数组
 * 类 名：Array
 * 作 者：javaliu
 * 创 建：2019年09月18日 10:56:00
 * 版 本：V1.0.0
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造数组对象
     *
     * @param capacity 初始化时的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
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
     *
     * @return 数组的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组所能容纳的数据的多少
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空,即数组不包含任何数据
     *
     * @return true:空, false:非空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组指定的位置添加元素, 设计思路: 将 index(包含) 之后的元素向后移动一位，先移动末尾的元素。
     *
     * @param index 元素索引
     * @param e     待添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数不合法");
        }

        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 将元素插入数组第一个元素
     *
     * @param e 待插入的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组尾部插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 移出元素, 只要将 index 后面的元素向前移动一位即可
     *
     * @param index 待移出元素的索引位置
     * @return 被移出的元素的值
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("移出失败，index 非法");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  // loitering objects != memory leak 闲荡的对象 != 内存溢出
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 移出第一个元素
     *
     * @return 被移出的元素的值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移出最后一个元素
     *
     * @return 被移出的元素的值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移出数组中第一个元素E
     *
     * @param e 待删除的元素
     */
    public void removeElement(E e) {
        int index = indexOf(e);
        if (-1 != index) {
            remove(index);
        }
    }

    /**
     * 修改指定位置上的元素
     *
     * @param index 索引位置
     * @param e     元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改元素失败，index 非法");
        }
        data[index] = e;
    }

    /**
     * 查找某个元素在数组中第一次出现的索引, 如果数组中无该元素，返回 -1
     *
     * @param e 待查找的元素
     * @return 索引位置
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取某个索引位置的元素
     *
     * @param index 索引位置
     * @return 返回该位置上的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取元素失败，index 非法");
        }
        return data[index];
    }

    /**
     * 数组中是否包含指定的元素，包含返回 true, 否则 false
     *
     * @param e 待查询的元素
     * @return 包含 true, 不包含 false
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 扩容
     *
     * @param newCapacity 扩容之后的大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array Size is %d, Capacity is %d \n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Array array = new Array();

        for (int i = 0; i < 5; i++) {
            array.add(i, i);
        }
        System.out.println(array.toString());
        array.addLast(100);
        System.out.println(array.toString());
        array.addFirst(20);
        System.out.println(array.toString());
        array.add(3, 30);
        System.out.println(array.toString());
    }
}
