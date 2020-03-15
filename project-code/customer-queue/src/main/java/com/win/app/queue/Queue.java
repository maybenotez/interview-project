package com.win.app.queue;

public interface Queue<T> {

    /**
     * 取出最先进入的元素
     * @return
     */
    T pop();

    /**
     *
     * @param value
     */
    void push(T value);

    boolean isEmpty();
}
