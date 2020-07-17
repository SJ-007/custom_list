package com.customlist;


import java.util.Iterator;
import java.util.Objects;

public class CustomLinkedList<T> implements CustomList<T> {

    private int currentSize;
    private Node head;
    private Node tail;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    @Override
    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        currentSize++;
    }

    // Zero based indexing.
    @Override
    public T get(int index) {
        Node temp = head;
        for (int i = 0; temp != null && i != index; i++) {
            temp = temp.next;
        }
        if(Objects.nonNull(temp)) {
            return temp.data;
        } else {
            return null;
        }
    }

    @Override
    public void update(int index, T data) {
        Node temp = head;
        for (int i = 0; temp != null && i != index; i++) {
            temp = temp.next;
        }
        if(Objects.nonNull(temp)) {
            temp.data = data;
        }
    }

    @Override
    public void insert(int index, T data) {
        Node node = new Node(data);
        if(index==0) {
            head = node;
            if(currentSize==0) {
                tail = node;
            }
        } if(index==currentSize) {
            tail.next = node;
            tail = tail.next;
        } else{
            Node temp = head;
            Node prev = null;
            for (int i = 0; temp != null && i != index; i++) {
                prev = temp;
                temp = temp.next;
            }
            if(Objects.nonNull(temp) && Objects.nonNull(prev)) {
                prev.next = node;
                node.next = temp;
            }
        }
        currentSize++;
    }

    @Override
    public boolean contains(T data) {
        Node temp = head;
        while(temp!=null) {
            if(temp.data.equals(data)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        int count = 0;
        Node prev = null;
        Node temp = head;
        while(temp!=null && index!=count) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        if(temp!=null && prev!=null) {
            T data = temp.data;
            prev.next = temp.next;
            return data;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(T data) {
        Node prev = null;
        Node temp = head;
        while(temp!=null && !data.equals(temp.data)) {
            prev = temp;
            temp = temp.next;
        }
        if(temp!=null && prev!=null) {
            prev.next = temp.next;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int len() {
        return currentSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node temp = head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }


    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public String toString() {
        String str = "";
        str = str.join(",", new Iterable<CharSequence>() {
            @Override
            public Iterator<CharSequence> iterator() {
                return new Iterator<CharSequence>() {
                    Node temp = head;
                    @Override
                    public boolean hasNext() {
                        return temp!=null;
                    }
                    @Override
                    public CharSequence next() {
                        CharSequence charSequence = temp.data.toString();
                        temp = temp.next;
                        return charSequence;
                    }
                };
            }
        });
        return str;
    }
}
