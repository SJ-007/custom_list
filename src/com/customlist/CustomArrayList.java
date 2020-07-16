package com.customlist;

import java.util.Iterator;
import java.util.stream.IntStream;

public class CustomArrayList<T> implements CustomList<T>, Iterable<T> {

    private int capacity;
    private int currentSize;
    private T[] array;

    public CustomArrayList() {
        this(2);
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.array =(T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if(capacity <= currentSize) {
            expand();
        }
        array[currentSize++] = data;
    }

    private void expand() {
        this.capacity *= 2;
        array = createArray(array);
    }

    private T[] createArray(T[] array) {
        T[] temp =(T[]) new Object[capacity];
        for(int i=0;i<currentSize;i++) {
            temp[i] = array[i];
        }
        return temp;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void update(int index, T data) {
        array[index] = data;
    }

    @Override
    public void insert(int index, T data) {
        if(currentSize >= capacity) {
            expand();
        }
        for(int i=currentSize; i>=index; i--) {
            array[i] = array[i-1];
        }
        array[index] = data;
        currentSize++;
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
        if(index < currentSize) {
            T temp = array[index];
            for(int i=index; i<currentSize-1;i++) {
                array[i] = array[i+1];
            }
            currentSize--;
            if(currentSize<= capacity/2) {
                shrink();
            }
            return temp;
        } else {
            return null;
        }
    }

    // First occurrence will be removed left to right.
    @Override
    public boolean remove(Object data) {
        for(int i=0;i<currentSize;i++) {
            if(array[i].equals(data)) {
                return remove(i) != null;
            }
        }
        return false;
    }

    private void shrink() {
        this.capacity /= 2;
        array = createArray(array);
    }

    @Override
    public int len() {
        return currentSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < currentSize;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString() {
//        return Arrays.toString(array);
        return IntStream.range(0, currentSize)
                .filter(i -> array[i]!=null)
                .mapToObj(i -> array[i].toString())
                .reduce((i, j) -> i+", "+j)
                .get();
    }
}
