package src.main.java.ru.itis.inf503.lab2_2;

import java.util.Iterator;

public class List503Impl<T> implements List503<T>, Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }


    private Node first;
    private Node last;


    public List503Impl() {
        first = null;
    }

    public List503Impl(T first) {
        this.first = new Node(first);
        this.last = this.first;
    }


    public void add(T elem) {
        if (first == null) {
            first = last = new Node(elem);
        } else {
            last.next = new Node(elem);
            last = last.next;
        }
    }

    public void add(T elem, int position) {
        if (position == 0) {
            Node newNode = new Node(elem);
            newNode.next = first;
            first = newNode;
            if (last == null) {
                last = newNode;
            }
            return;
        }

        Node temp = first;
        for(int i = 0; i < position-1; i++) {
            if (temp.next == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }

        Node newNode = new Node(elem);
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            last = newNode;
        }
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public T get(int position) throws IndexOutOfBoundsException {
        Node temp = first;
        for(int i = 0; i < position; i++) {
            if (temp == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }
        if (temp == null) throw new IndexOutOfBoundsException();
        return temp.value;
    }

    public T remove(int position) {
        if (position == 0) {
            T value = first.value;
            first = first.next;
            if (first == null) last = null;
            return value;
        }

        Node temp = first;
        for(int i = 0; i < position - 1; i++) {
            if (temp.next == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }
        T value = temp.next.value;
        temp.next = temp.next.next;

        if (temp.next == null) last = temp;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(T o) {
        Node temp = first;
        while (temp != null) {
            if (temp.value.equals(o)) return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node temp = first;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.value;
            temp = temp.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = first;
        while(temp != null) {
            stringBuilder.append(temp.value).append(" ");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}

