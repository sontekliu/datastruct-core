package com.javaliu.collection.linkedlist;

/**
 * 描 述：链表
 * 类 名：LinkedList
 * 作 者：liushijun
 * 创 建：2019年09月25日 09:44:00
 * 版 本：V1.0.0
 */
public class LinkedList<E> {

    /**
     * 虚拟头节点
     */
    private Node<E> dummyHead;
    private int size;

    public static class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public LinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.size = 0;
    }

    /**
     * 返回链表的大小
     * @return      数组的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return      true: 空, false: 非空
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
