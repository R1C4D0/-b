package deque;

import java.util.Iterator;

public interface Deque<T> {
    int size();

    boolean isEmpty();

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T get(int index);

    void printDeque();

    public Iterator<T> iterator();

    default boolean equals(Deque<T> other) {
        if (size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

}
