package deque;

import java.util.Iterator;

/*
 *  INVARIANTS:
 *  - The next item added by addFirst will be placed at items[nextFirst]
 *  - The next item added by addLast will be placed at items[nextLast]
 *  - The item at items[nextFirst + 1] % items.length is the first item in the deque
 *  - The item at items[(nextLast - 1 + items.length) % items.length] is the last item in the deque
 *  - The number of items in the deque is size
 *  - The capacity of the deque is always a power of 2
 *  - The usage ratio of the deque is always greater than MIN_USAGE_RATIO unless the capacity is less than MIN_CAPACITY
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final int INIT_CAPACITY = 8;
    private static final int RESIZE_FACTOR = 2;
    private static final int MIN_CAPACITY = 16; //For length MIN_CAPACITY or less, do not consider MIN_USAGE_RATIO
    private static final int MIN_USAGE_RATIO = 4;

    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[INIT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        checkCapacity();
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    @Override
    public void addLast(T item) {
        checkCapacity();
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = get(0);
        nextFirst = (nextFirst + 1) % items.length;
        items[nextFirst] = null;    // null out the deleted item for garbage collection
        size--;
        checkCapacity();
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = get(size - 1);
        nextLast = (nextLast - 1 + items.length) % items.length;
        items[nextLast] = null;    // null out the deleted item for garbage collection
        size--;
        checkCapacity();
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    @Override
    public void printDeque() {
        int index = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int oldIndex = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[oldIndex];
            oldIndex = (oldIndex + 1) % items.length;
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void checkCapacity() {
        if (size == items.length) {
            resize(size * RESIZE_FACTOR);
        } else if (size <= items.length / MIN_USAGE_RATIO && size > MIN_CAPACITY) {
            resize(items.length / RESIZE_FACTOR);
        }
    }


    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        public ArrayDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T item = get(index);
            index++;
            return item;
        }
    }
}
