package com.customlist;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
