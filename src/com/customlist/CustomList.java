package com.customlist;

public interface CustomList<T> {
    void add(T data);
    T get(int index);
    void update(int index, T data);
    void insert(int index, T data);
    boolean contains(T data);
    T remove(int index);
    boolean remove(T data);
    int len();
}
