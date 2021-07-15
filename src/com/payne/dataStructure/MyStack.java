package com.payne.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.dataStructure
 * Date       2021/02/25 - 09:59
 * Author     Payne.
 * About      类描述：
 */

abstract class MyStack<T> {
    abstract T pop();

    abstract T push(T t);

    abstract T peek();

    abstract boolean isEmpty();
}

class ArrStack extends MyStack<Integer> {

    int max;
    Integer[] arr;
    int top = -1;

    public ArrStack(int max) {
        this.max = max;
        arr = new Integer[max];
    }


    @Override
    synchronized Integer pop() {
        return null;
    }

    @Override
    synchronized Integer push(Integer integer) {
        return null;
    }

    @Override
    synchronized Integer peek() {
        return null;
    }

    @Override
    boolean isEmpty() {
        return top < 0;
    }
}

class ListStack<T> extends MyStack<T> {

    private List<T> list = new ArrayList<>();

    private T getTop(boolean del) {
        if (!isEmpty()) {
            int last = list.size() - 1;
            T t = list.get(last);
            if (del) {
                list.remove(last);
            }
            return t;

        }

        return null;
    }


    @Override
    public synchronized T pop() {
        return getTop(true);
    }

    @Override
    public synchronized T push(T t) {
        list.add(t);
        return t;
    }

    @Override
    public synchronized T peek() {
        return getTop(false);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
