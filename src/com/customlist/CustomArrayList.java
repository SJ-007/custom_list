package com.customlist;

import java.util.Iterator;

public class CustomArrayList<T> implements CustomList<T>, Iterator<T> {

    private int capacity;
    private int currentSize;
    private Object[] array;

    public CustomArrayList() {
        this(2);
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.array = new Object[capacity];
    }

    @Override
    public void add(T data) {
        if(capacity >= currentSize) {
            array = resize(array);
        }
        array[currentSize++] = data;
    }

    private Object[] resize(Object[] array) {
        this.capacity *= 2;
        Object[] temp = new Object[capacity];
        for(int i=0;i<currentSize;i++) {
            temp[i] = array[i];
        }
        return temp;
    }

    @Override
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void update(int index, T data) {
        array[index] = data;
    }

    @Override
    public void insert(int index, T data) {

    }

    @Override
    public boolean contains(T data) {
        for(int i=0;i<currentSize;i++) {
            if(array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int len() {
        return currentSize;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
